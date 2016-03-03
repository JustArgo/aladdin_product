package com.maiquan.aladdin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.maiquan.aladdin.mapper.ProductDetailMapper;
import com.maiquan.aladdin.service.IProductDetailService;

public class ProductDetailServiceImpl implements IProductDetailService{

	@Autowired
	private ProductDetailMapper productDetailMapper;
	
	@Override
	public String getProductDescSegment(Integer productID,Integer startPos) {
		return productDetailMapper.getProductDescSegment(productID,startPos);
	}
	
}
