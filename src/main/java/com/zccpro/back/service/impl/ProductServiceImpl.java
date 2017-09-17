package com.zccpro.back.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletResponseWrapper;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import com.zccpro.back.service.ProductService;
import com.zccpro.constants.Constants;
import com.zccpro.dao.ImgMapper;
import com.zccpro.dao.ProductMapper;
import com.zccpro.dao.SkuMapper;
import com.zccpro.domain.Img;
import com.zccpro.domain.Product;
import com.zccpro.domain.Sku;
import com.zccpro.domain.vo.ProductQuery;
import com.zccpro.utils.MyStringUtils;

import redis.clients.jedis.Jedis;
@Service("productservice")
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductMapper productMapper;
	
	@Resource 
	private ImgMapper imgMapper;
	
	@Resource 
	private SkuMapper skuMapper;
	
	@Resource
	private Jedis jedis;
	
	@Resource
	SolrServer solrServer;
	
	public List<Product> selectProductList() {
		List<Product> List = productMapper.selectProductList();
		return List;
	}

	public HashMap<String, Object> selectProductListByBean(String name, Long brandId, Boolean isShow, Integer pageNo) {
		ProductQuery productQuery = new ProductQuery();
		if(name!=null){
			productQuery.setName(name);
		}
		if(brandId!=null){
			productQuery.setBrandId(brandId);
		}
		if(isShow!=null){
			productQuery.setIsShow(isShow);
		}
		if(pageNo!=null){
			productQuery.setPageNo(pageNo);
			productQuery.setStartRow(productQuery.getStartRow());
		}
		int totalCount = productMapper.selectCountByProduct(productQuery);
		productQuery.setTotoalCount(totalCount);
		productQuery.setTotalPage(productQuery.getTotalPage());
		HashMap<String,Object> map = new HashMap<String, Object>();
		List<Product> productList = productMapper.selectPageByProduct(productQuery);
		
		for (Product product : productList) {
			Long productId = product.getId();
			Img img = imgMapper.selectByProductId(productId);
			if(img!=null){
				if(img.getUrl().startsWith("group")){
					product.setWebSite(Constants.IMG_URL+img.getUrl());
				}else{
					product.setWebSite(img.getUrl());
				}
				product.setImg(img);
			}
		}
		map.put("productList", productList);
		map.put("productQuery", productQuery);
		return map;
	}
	
	

	public void deleteByIds(Long[] ids) {
		skuMapper.deleteByProIds(ids);
		imgMapper.deleteByProIds(ids);
		productMapper.deleteByIds(ids);
	}

	/**
	 * 插入商品信息
	 */
	public void insertProduct(Product product) {
		product.setId(jedis.incr("productId"));//设置商品Id
		product.setIsShow(false);//上下架，默认下架
		product.setIsDel(true);//是否删除，默认不删除
		product.setCreateTime(new Date());//创建时间
		productMapper.insertSelective(product);
		Img img = product.getImg();
		img.setProductId(product.getId());
		img.setIsDef(true);
		imgMapper.insert(img);
		//TODO 库存
		String[] colors = product.getColors().split(",");
		String[] sizes = product.getSizes().split(",");
		for (String color : colors) {
			for (String size : sizes) {
				Sku sku = new Sku();
				//商品ＩＤ
				sku.setProductId(product.getId());
				//颜色ＩＤ
				sku.setColorId(Long.parseLong(color));
				//尺码 
				sku.setSize(size);
				//运费
				sku.setDeliveFee(10f);
				//价格
				sku.setPrice(0f);
				//库存
				sku.setStock(0);
				//购买限制
				sku.setUpperLimit(200);
				//市场价
				sku.setMarketPrice(0f);
				//添加时间 
				sku.setCreateTime(new Date());
				//保存SKu
				skuMapper.insertSelective(sku);
			}
		}
	}

	public Product selectByID(Long id) {
		Product product = productMapper.selectByPrimaryKey(id);
		Long productId = product.getId();
		Img img = imgMapper.selectByProductId(productId);
		if(img.getUrl().startsWith("group")){
			product.setWebSite(Constants.IMG_URL+img.getUrl());
		}else{
			product.setWebSite(img.getUrl());
		}
		product.setImg(img);
		return product;
	}

	public int updateByIDSelective(Product record) {
		return productMapper.updateByPrimaryKeySelective(record);
	}

	
	public void isShow(Long[] ids) {
		Product product = new Product();
		product.setIsShow(true);
		for (Long id : ids) {
			product.setId(id);
			int isShow = productMapper.updateByPrimaryKeySelective(product);//修改上架状态
			if(isShow==1){
				Product productquery = productMapper.selectByPrimaryKey(id);
				SolrInputDocument doc = new SolrInputDocument();
				doc.setField("id", id.toString());//id
				doc.setField("name_ik", productquery.getName().toString());//name
				Img img = imgMapper.selectByProductId(id);//Url
				if(img!=null){//TODO
					if(img.getUrl().startsWith("group")){
						doc.setField("imgUrl", Constants.IMG_URL+img.getUrl().toString());
					}else{
						doc.setField("imgUrl", img.getUrl());
					}
				}
				List<Sku> skuList = skuMapper.selectByProductId(id);
				doc.setField("price", skuList.get(0).getPrice().toString());//价格
				doc.setField("brandId", productquery.getBrandId().toString());//品牌名称
				doc.setField("lastModified", MyStringUtils.getCurrent24Date());//最后更改时间
				try {
					solrServer.add(doc);
					solrServer.commit();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void noShow(Long[] ids) {
		Product product = new Product();
		product.setIsShow(false);
		for (Long id : ids) {
			product.setId(id);
			int noShow = productMapper.updateByPrimaryKeySelective(product);
			if(noShow==1){
				try {
					solrServer.deleteById(id.toString());
					solrServer.commit();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 前台数据solr中商品对象
	 * @throws SolrServerException 
	 */
	public Map<String,Object> selectProductFromSolr(Integer pageNo, String keyword, Long brandId, String price) throws SolrServerException {
		ProductQuery productQuery = new ProductQuery();
		if(pageNo!=null){
			productQuery.setPageNo(pageNo);
		}
		
		//SOlr查询
		SolrQuery solrQuery = new SolrQuery();
		if(keyword!=null){
			productQuery.setName(keyword);
			solrQuery.set("q", "name_ik:" + keyword);
		}else{
//			solrQuery.set("q", "*:*");
			solrQuery.set("q", "name_ik:" + "2014");
		}
		
		//过滤条件
		if(null != brandId){
			productQuery.setBrandId(brandId);
			solrQuery.addFilterQuery("brandId:" + brandId);
		}
		
		//价格  0-79   600
		if(null != price){
			productQuery.setPrice(Float.valueOf(price));
			//切
			String[] split = price.split("-");
			if(split.length == 2){
				Float startP = new Float(split[0]);
				Float endP = new Float(split[1]);
				solrQuery.addFilterQuery("price:[" + startP + " TO " + endP + "]");
			}else if(split.length == 1){
				Float startP = new Float(split[0]);
				solrQuery.addFilterQuery("price:[" + startP + " TO *]");
			}
		}
		//排序  价格
		solrQuery.addSort("price",ORDER.asc);
	
		//起始行
		solrQuery.setStart(productQuery.getStartRow());
		//每页显示条数
		solrQuery.setRows(Constants.FrontPAGESIZE);
		
		//高亮
		solrQuery.setHighlight(true);// 开启高亮组件
		solrQuery.addHighlightField("name_ik");// 高亮字段
		//标记，高亮关键字前缀
		solrQuery.setHighlightSimplePre("<font color='red'>");
		solrQuery.setHighlightSimplePost("</font>");//后缀
		//获取高亮分片数，一般搜索词可能分布在文章中的不同位置，其所在一定长度的 
		  /** 语句即为一个片段，默认为1，但根据业务需要有时候需要多取出几个分片。
		   - 此处设置决定下文中titleList, contentList中元素的个数
		        **/
//		solrQuery.setHighlight(true).setHighlightSnippets(1); 
		    /**
		    每个分片的最大长度，默认为100。
		    适当设置此值，如果太小，高亮的标题可能会显不全；
		    设置太大，摘要可能会太长。
		    **/
//		solrQuery.setHighlightFragsize(150);
		//向solr 查询
		QueryResponse response = solrServer.query(solrQuery);
		//结果集
		SolrDocumentList docs = response.getResults();
		
		//返回高亮
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
		//总条数
		long numFound = docs.getNumFound();
		productQuery.setTotoalCount((int) numFound);
		productQuery.setTotalPage(productQuery.getTotalPage());		
		List<Product> productList = new ArrayList<Product>();
		for (SolrDocument doc : docs) {
			Product product = new Product();
			//商品ID
			String id = (String)doc.get("id");
			product.setId(Long.parseLong(id));
			//商品名称
			Map<String, List<String>> map = highlighting.get(id);
			List<String> list = map.get("name_ik");
			product.setName(list.get(0));
			String nameExHtml = (String) doc.get("name_ik");
			product.setNameExHtml(nameExHtml);
			//价格
			product.setPrice(Float.parseFloat(doc.get("price").toString()));
			product.setWebSite((String)doc.get("imgUrl"));
			//品牌ID
			product.setBrandId(Long.parseLong(doc.get("brandId").toString()));
			productList.add(product);
		}
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("productList", productList);
		hashMap.put("productQuery", productQuery);
		return hashMap;
	}
}
