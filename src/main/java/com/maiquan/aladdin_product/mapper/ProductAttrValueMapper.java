package com.maiquan.aladdin_product.mapper;

import java.util.List;

import com.maiquan.aladdin_product.domain.ProductAttrValue;

public interface ProductAttrValueMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(ProductAttrValue record);

    int insertSelective(ProductAttrValue record);

    ProductAttrValue selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(ProductAttrValue record);

    int updateByPrimaryKey(ProductAttrValue record);
    
    String selectAttrValueByID(Integer ID);

	List<ProductAttrValue> selectByAttrID(Integer attrID);
}