package com.zccpro;

import org.junit.Test;

import com.zccpro.domain.vo.ProductQuery;

public class TestPage {
	@Test
	public void teststartRow(){
		ProductQuery productQuery = new ProductQuery();
		productQuery.setPageNo(2);
		Integer startRow = productQuery.getStartRow();
		System.out.println(startRow);
	}
}
