package com.maiquan.aladdin.service;

import java.util.List;

import com.maiquan.aladdin.domain.ProductSku;


public interface IProductSkuService {

	ProductSku getSkuByID(Integer ID);
	List<ProductSku> getSkuByProductID(Integer productID);
	
}
