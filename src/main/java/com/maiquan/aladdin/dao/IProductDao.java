package com.maiquan.aladdin.dao;

import com.maiquan.aladdin.domain.Product;


public interface IProductDao {

	void addProduct(Product product);
	Product getProduct(Integer ID);
	
}
