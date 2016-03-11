package com.maiquan.aladdin_product.mapper;

import com.maiquan.aladdin_product.domain.ProductDetail;

public interface ProductDetailMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    ProductDetail selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKeyWithBLOBs(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);

	String getProductDescSegment(Integer productID,Integer startPos);
}