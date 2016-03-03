package com.maiquan.aladdin.mapper;

import com.maiquan.aladdin.domain.ProductDetail;

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