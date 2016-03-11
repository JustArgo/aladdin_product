package com.maiquan.aladdin_product.mapper;

import java.util.List;

import com.maiquan.aladdin_product.domain.ProductAttr;

public interface ProductAttrMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(ProductAttr record);

    int insertSelective(ProductAttr record);

    ProductAttr selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(ProductAttr record);

    int updateByPrimaryKey(ProductAttr record);
    
    String selectAttrNameByID(Integer ID);
    
    List<ProductAttr> selectByProductID(Integer productID);
}