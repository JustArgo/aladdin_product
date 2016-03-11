package com.maiquan.aladdin_product.service;

import com.maiquan.aladdin_product.vo.ProductVo;

public interface IProductVoService {
	
	/**
	 * 获得商品详情对象
	 * @param productID
	 * @return
	 */
	ProductVo getProductVo(Integer productID, String requestID);
	
}
