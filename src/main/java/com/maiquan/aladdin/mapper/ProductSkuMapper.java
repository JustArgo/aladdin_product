package com.maiquan.aladdin.mapper;

import java.util.List;

import com.maiquan.aladdin.domain.ProductSku;

public interface ProductSkuMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(ProductSku record);

    int insertSelective(ProductSku record);

    ProductSku selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(ProductSku record);

    int updateByPrimaryKey(ProductSku record);
    
    List<ProductSku> selectByProductID(Integer productID);
}