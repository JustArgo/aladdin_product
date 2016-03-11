package com.maiquan.aladdin_product.service;

import java.util.List;

import com.maiquan.aladdin_product.domain.Product;
import com.maiquan.aladdin_product.domain.ProductAttr;
import com.maiquan.aladdin_product.domain.ProductAttrValue;

public interface IProductService {

	/**
	 * 查找指定状态的商品
	 * @param status
	 * @param requestID
	 * @return
	 */
	List<Product> getProductListByStatus(String status, String requestID);
	
	/**
	 * 查找所有商品
	 * @param requestID
	 * @return
	 */
	List<Product> queryProductList(String requestID);
	
	/**
	 * 根据id查找商品
	 * @param ID
	 * @param requestID
	 * @return
	 */
	Product queryProduct(Integer ID, String requestID);
	
	/**
	 * 根据类目查找商品
	 * @param categoryID
	 * @param requestID
	 * @return
	 */
	List<Product> getProductListByCategoryID(Integer categoryID, String requestID);
	
	/**
	 * 更新商品
	 * @param product
	 * @param requestID
	 * @return
	 */
	int updateProduct(Product product, String requestID);
	
	/**
	 * 删除商品
	 * @param ID
	 * @param requestID
	 * @return
	 */
	int deleteProduct(Integer ID, String requestID);
	
	/**
	 * 下架商品
	 * @param ID
	 * @param requestID
	 * @return
	 */
	int offShelfProduct(Integer ID, String requestID);
	
	/**
	 * 增加商品
	 * @param product
	 * @param requestID
	 * @return
	 */
	int addProduct(Product product, String requestID);
	
	/**
	 * 根据商品id获得商品属性
	 * @param productID
	 * @param requestID
	 * @return
	 */
	List<ProductAttr> getProductAttrByProductID(Integer productID, String requestID);
	
	/**
	 * 根据商品属性ID获得 该属性对应的可选值
	 * @param attrID
	 * @param requestID
	 * @return
	 */
	List<ProductAttrValue> getAttrValuesByAttrID(Integer attrID, String requestID);
}
