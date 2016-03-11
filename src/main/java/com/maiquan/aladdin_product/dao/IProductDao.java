package com.maiquan.aladdin_product.dao;

import com.maiquan.aladdin_product.domain.Product;


public interface IProductDao {

	/**
	 * 将商品缓存到redis中
	 * @param product
	 */
	void addProduct(Product product);
	
	/**
	 * 查找缓存是否有 指定商品
	 * @param ID
	 * @return
	 */
	Product getProduct(Integer ID);
	
	/**
	 * 将指定商品从缓存中清除
	 * @param ID
	 */
	void removeProduct(Integer ID);
	
	/**
	 * 将所有商品信息从缓存中清除
	 */
	void removeAllProduct();
	
}
