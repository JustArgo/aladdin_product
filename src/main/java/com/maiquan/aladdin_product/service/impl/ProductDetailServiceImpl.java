package com.maiquan.aladdin_product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.maiquan.aladdin_product.mapper.ProductDetailMapper;
import com.maiquan.aladdin_product.service.IProductDetailService;
import com.maiquan.aladdin_product.util.LogUtil;

public class ProductDetailServiceImpl implements IProductDetailService{

	@Autowired
	private ProductDetailMapper productDetailMapper;
	
	@Override
	public String getProductDescSegment(Integer productID,Integer startPos,String requestID) {
		
		LogUtil.logInput("商品详情微服务","getProductDescSegment",requestID,productID,startPos);
		
		String productDescSegment = productDetailMapper.getProductDescSegment(productID,startPos);
		
		LogUtil.logOutput("商品详情微服务","getProductDescSegment",requestID,productDescSegment);
		
		return productDescSegment;
	}
	
}
