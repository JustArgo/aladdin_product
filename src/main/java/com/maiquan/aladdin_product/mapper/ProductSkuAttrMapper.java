package com.maiquan.aladdin_product.mapper;

import java.util.List;

import com.maiquan.aladdin_product.domain.ProductSkuAttr;

public interface ProductSkuAttrMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(ProductSkuAttr record);

    int insertSelective(ProductSkuAttr record);

    ProductSkuAttr selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(ProductSkuAttr record);

    int updateByPrimaryKey(ProductSkuAttr record);

	List<ProductSkuAttr> selectBySkuID(Integer skuID);
}