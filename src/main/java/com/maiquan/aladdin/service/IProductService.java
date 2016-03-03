package com.maiquan.aladdin.service;

import java.util.List;

import com.maiquan.aladdin.domain.Product;



public interface IProductService {

	//查找指定状态的商品
	List<Product> getProductListByStatus(String status);
	
	//查找所有商品
	List<Product> queryProductList();
	
	//根据id查找商品
	Product queryProduct(Integer ID);
	
	//根据类目查找商品
	List<Product> getProductListByCategoryID(Integer categoryID);
	
	//更新商品
	int updateProduct(Product product);
	
	//删除商品
	int deleteProduct(Integer ID);
	
	//下架商品
	int offShelfProduct(Integer ID);
	
	//增加商品
	int addProduct(Product product);
	
}
