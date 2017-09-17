package com.zccpro.front;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zccpro.back.service.ProductService;
import com.zccpro.utils.MyStringUtils;

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath:spring-config.xml"}) 
public class SolrTest {

	@Resource
	ProductService productservice;
	@Resource
	SolrServer solrServer;
	@Test
	public void testSolrAdd() throws SolrServerException, IOException{
//	SolrServer solrServer = new HttpSolrServer("http://192.168.211.133:8080/solr/mycore");
	
	SolrInputDocument doc = new SolrInputDocument();
	doc.setField("id", 6);
	doc.setField("name", "哈哈3");
	doc.setField("imgUrl", "url");
	doc.setField("price", "318.0");//价格
	doc.setField("brandId", "2");//价格
	doc.setField("lastModified", MyStringUtils.getCurrent24Date());//最后更改时间
	
	solrServer.add(doc);
	solrServer.commit();
	}
	
	@Test
	public void testSolrDel() throws SolrServerException, IOException{
	
	solrServer.deleteById("2");

	solrServer.commit();
	}
	@Test
	public void testSolrQue() throws SolrServerException{
		productservice.selectProductFromSolr(null, null, null, null);
	}
}
