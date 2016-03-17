package com.maiquan.aladdin_product.service;

import java.util.List;

import com.maiquan.aladdin_product.domain.ProductSku;
import com.maiquan.aladdin_product.domain.ProductSkuAttr;


public interface IProductSkuService {

	/**
	 * 根据id 获得一个 商品sku
	 * @param ID
	 * @return
	 */
	ProductSku getSkuByID(Integer ID, String requestID);
	
	/**
	 * 根据商品ID 获得该商品 所有的sku
	 * @param productID
	 * @return
	 */
	List<ProductSku> getSkuByProductID(Integer productID, String requestID);
	
	/**
	 * 获得 sku属性列表  颜色:红色  尺码:X
	 * @param ID
	 * @return
	 */
	List<String> getSkuStr(Integer skuID, String requestID);
	
	/**
	 * 根据skuID 获得该sku拥有的属性
	 * @param skuID
	 * @return
	 */
	List<ProductSkuAttr> getSkuAttrBySkuID(Integer skuID, String requestID);
	
	/**
	 * 更新sku
	 * @param productSku
	 * @param requestID
	 * @return
	 */
	int updateSku(ProductSku productSku, String requestID);
	
}
