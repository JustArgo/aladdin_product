package com.maiquan.aladdin.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.maiquan.aladdin.dao.IProductDao;
import com.maiquan.aladdin.domain.Product;
import com.maiquan.aladdin.domain.ProductSku;
import com.maiquan.aladdin.mapper.ProductMapper;
import com.maiquan.aladdin.mapper.ProductSkuMapper;
import com.maiquan.aladdin.service.IProductService;

public class ProductServiceImpl implements IProductService{

	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private IProductDao redisDao;
	
	@Autowired
	private ProductSkuMapper productSkuMapper;
	
	@Override
	public Product queryProduct(Integer ID) {
		
		Product p = redisDao.getProduct(ID);
		List<ProductSku> skus = productSkuMapper.selectByProductID(ID); 
		if(p==null){
			p = productMapper.selectByPrimaryKey(ID);
			redisDao.addProduct(p);
		}
		return p;
	}

	@Override
	public List<Product> getProductListByCategoryID(Integer categoryID) {
		Product p = new Product();
		p.setCategoryID(categoryID);
		return productMapper.selectByCondition(p);
	}



	@Override
	public int addProduct(Product product) {
		
		productMapper.insert(product);
		return 1;
		
	}

	@Override
	public List<Product> getProductListByStatus(String status) {

		Product p = new Product();
		p.setStatus(status);
		List<Product> products = productMapper.selectByCondition(p);
		
		return products;
	}

	@Override
	public List<Product> queryProductList() {

		
		return null;
	}

	@Override
	public int updateProduct(Product product) {
		return 0;
	}

	@Override
	public int deleteProduct(Integer ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int offShelfProduct(Integer ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}
