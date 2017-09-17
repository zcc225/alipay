package com.zccpro.back.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;

import com.zccpro.domain.Product;

public interface ProductService {
	/**
	 * 查询商品列表
	 * @return
	 */
	List<Product> selectProductList();
	
	/**
	 * 查询商品列表 过滤
	 * @param pageNo 
	 * @param isShow 
	 * @param brandId 
	 * @param name 
	 * @return
	 */
	HashMap<String, Object> selectProductListByBean(String name, Long brandId, Boolean isShow, Integer pageNo);
	
	/**
	 *删除商品
	 * @param id
	 * @return
	 */
	void deleteByIds(Long[] ids);

    /**
     * 插入商品
     * @param record
     * @return
     */
    void insertProduct(Product record);

    /**
     * 根据Id 查询商品
     * @param id
     * @return
     */
    Product selectByID(Long id);

    /**
     * 修改商品
     * @param record
     * @return
     */
    int updateByIDSelective(Product record);

	void isShow(Long[] ids);

	void noShow(Long[] ids);

	Map selectProductFromSolr(Integer pageNo, String keyword, Long brandId, String price) throws SolrServerException;

}
