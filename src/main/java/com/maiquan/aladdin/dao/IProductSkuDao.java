package com.maiquan.aladdin.dao;

import java.util.List;

import com.maiquan.aladdin.domain.ProductSku;

public interface IProductSkuDao {
	void addProductSku(ProductSku sku);
	ProductSku getProductSku(Integer ID);
	List<ProductSku> getProductSkuByProductID(Integer productSkuID);
	void addProductSkuListWithSameProductID(List<ProductSku> skus);
} 
