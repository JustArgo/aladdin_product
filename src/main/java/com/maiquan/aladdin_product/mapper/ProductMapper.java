package com.maiquan.aladdin_product.mapper;

import java.util.List;

import com.maiquan.aladdin_product.domain.Product;

public interface ProductMapper {
	
    int deleteByPrimaryKey(Integer ID);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer ID);
    
    List<Product> selectByCondition(Product product);
    
    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}