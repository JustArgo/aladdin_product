package com.maiquan.aladdin_product.mapper;

import java.util.List;

import com.maiquan.aladdin_product.domain.ProductSku;

public interface ProductSkuMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(ProductSku record);

    int insertSelective(ProductSku record);

    ProductSku selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(ProductSku record);

    int updateByPrimaryKey(ProductSku record);
    
    List<ProductSku> selectByProductID(Integer productID);
}