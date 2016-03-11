package com.maiquan.aladdin_product.service;

public interface IProductDetailService {

	/**
	 * 分段获得商品的详细描述信息
	 * @param productID
	 * @param segNum
	 * @return
	 */
	String getProductDescSegment(Integer productID,Integer segNum, String requestID);
	
}
