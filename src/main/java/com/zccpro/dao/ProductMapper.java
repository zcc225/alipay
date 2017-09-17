package com.zccpro.dao;

import java.util.List;

import com.zccpro.domain.Brand;
import com.zccpro.domain.Product;
import com.zccpro.domain.vo.ProductQuery;

public interface ProductMapper {
	
	List<Product> selectProductList();
	/**
	 *删除商品
	 * @param id
	 * @return
	 */
    int deleteByIds(Long[] ids);

    /**
     * 插入商品
     * @param record
     * @return
     */
    int insertSelective(Product record);

    /**
     * 根据Id 查询商品
     * @param id
     * @return
     */
    Product selectByPrimaryKey(Long id);

    /**
     * 修改商品
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * 查询分页数据
     * @param product
     * @return
     */
    List<Product> selectPageByProduct(Product product);
    /**
     * 查询数据总条数
     * @param productQuery
     * @return
     */
	int selectCountByProduct(ProductQuery productQuery);

}