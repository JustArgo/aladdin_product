package com.maiquan.aladdin_product.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.maiquan.aladdin_product.dao.IProductDao;
import com.maiquan.aladdin_product.domain.Product;
import com.maiquan.aladdin_product.domain.ProductAttr;
import com.maiquan.aladdin_product.domain.ProductAttrValue;
import com.maiquan.aladdin_product.mapper.ProductAttrMapper;
import com.maiquan.aladdin_product.mapper.ProductAttrValueMapper;
import com.maiquan.aladdin_product.mapper.ProductMapper;
import com.maiquan.aladdin_product.mapper.ProductSkuMapper;
import com.maiquan.aladdin_product.service.IProductService;
import com.maiquan.aladdin_product.util.LogUtil;

public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private IProductDao productDao;
	
	@Autowired
	private ProductSkuMapper productSkuMapper;
	
	@Autowired
	private ProductAttrMapper productAttrMapper;
	
	@Autowired
	private ProductAttrValueMapper productAttrValueMapper;
	
	@Override
	public Product queryProduct(Integer productID, String requestID) {
		
		LogUtil.logInput("商品微服务", "queryProduct", requestID, productID);
		
		Product p = productDao.getProduct(productID);

		if(p==null){
			p = productMapper.selectByPrimaryKey(productID);
			productDao.addProduct(p);
		}
		
		LogUtil.logOutput("商品微服务", "queryProduct", requestID, p);
		
		return p;
	}

	@Override
	public List<Product> getProductListByCategoryID(Integer categoryID, String requestID) {
		
		LogUtil.logInput("商品微服务", "getProductListByCategoryID", requestID, categoryID);
		
		Product p = new Product();
		p.setCategoryID(categoryID);
		
		List<Product> products = productMapper.selectByCondition(p);
		
		LogUtil.logOutput("商品微服务", "getProductListByCategoryID", requestID, p);
		
		return products;
	}



	@Override
	public int addProduct(Product product, String requestID) {
		
		LogUtil.logInput("商品微服务", "addProduct", requestID, product);
		
		productMapper.insert(product);
		
		LogUtil.logOutput("商品微服务", "addProduct", requestID, "无");
		
		return 1;
		
	}

	@Override
	public List<Product> getProductListByStatus(String status, String requestID) {

		LogUtil.logInput("商品微服务", "getProductListByStatus", requestID, status);
		
		Product p = new Product();
		p.setStatus(status);
		List<Product> products = productMapper.selectByCondition(p);
		
		LogUtil.logOutput("商品微服务", "getProductListByStatus", requestID, products);
		
		return products;
	}

	@Override
	public List<Product> queryProductList(String requestID) {
		return null;
	}

	@Override
	public int updateProduct(Product product, String requestID) {
		
		LogUtil.logInput("商品微服务", "updateProduct", requestID, product);
		
		productMapper.updateByPrimaryKeySelective(product);
		
		LogUtil.logOutput("商品微服务", "updateProduct", requestID, "无");
		
		return 0;
	}

	@Override
	public int deleteProduct(Integer productID, String requestID) {
		
		LogUtil.logInput("商品微服务", "deleteProduct", requestID, productID);
		
		Product product = new Product();
		product.setID(productID);
		product.setStatus("DEL");
		productMapper.updateByPrimaryKeySelective(product);
		
		LogUtil.logOutput("商品微服务", "deleteProduct", requestID, "无");
		
		return 0;
	}

	@Override
	public int offShelfProduct(Integer productID, String requestID) {
		
		LogUtil.logInput("商品微服务", "ofShelfProduct", requestID, productID);
		
		Product product = new Product();
		product.setID(productID);
		product.setStatus("DW#");
		
		productMapper.updateByPrimaryKeySelective(product);
		
		LogUtil.logOutput("商品微服务", "ofShelfProduct", requestID, "无");
		
		return 0;
	}

	@Override
	public List<ProductAttr> getProductAttrByProductID(Integer productID, String requestID) {
		
		LogUtil.logInput("商品微服务","getProductAttrByProductID",requestID,productID);
		
		List<ProductAttr> productAttrs = productAttrMapper.selectByProductID(productID);
		
		LogUtil.logOutput("商品微服务","getProductAttrByProductID",requestID,productAttrs);
		
		return productAttrs;
	}

	@Override
	public List<ProductAttrValue> getAttrValuesByAttrID(Integer attrID, String requestID) {
		
		LogUtil.logInput("商品微服务","getAttrValuesByAttrID",requestID,attrID);
		
		List<ProductAttrValue> productAttrValues = productAttrValueMapper.selectByAttrID(attrID);
		
		LogUtil.logOutput("商品微服务","getAttrValuesByAttrID",requestID,productAttrValues);
		
		return productAttrValues;
	}
	
	
}
