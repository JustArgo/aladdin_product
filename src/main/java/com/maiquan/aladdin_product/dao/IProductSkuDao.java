package com.maiquan.aladdin_product.dao;

import java.util.List;

import com.maiquan.aladdin_product.domain.ProductSku;

public interface IProductSkuDao {
	
	/**
	 * 新增productSku
	 * @param sku
	 */
	void addProductSku(ProductSku sku);
	
	/**
	 * 从redis中获取productSku
	 * @param ID
	 * @return
	 */
	ProductSku getProductSku(Integer ID);
	
	/**
	 * 根据productID 获取出productSku
	 * @param productSkuID
	 * @return
	 */
	List<ProductSku> getProductSkuByProductID(Integer productID);
	
	/**
	 * 新增相同productID的sku
	 * @param skus
	 */
	void addProductSkuListWithSameProductID(List<ProductSku> skus);
	
	/**
	 * 从redis中移除指定ID的productSku
	 * @param productSkuID
	 */
	void removeProductSku(Integer productSkuID);
	
	/**
	 * 从redis中移除所有的productSku
	 */
	void removeAllProductSku();
	
	
} 
