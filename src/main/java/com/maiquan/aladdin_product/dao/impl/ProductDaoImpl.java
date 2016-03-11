package com.maiquan.aladdin_product.dao.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.maiquan.aladdin_product.dao.IProductDao;
import com.maiquan.aladdin_product.domain.Product;

@Repository
public class ProductDaoImpl implements IProductDao{

	@Autowired
	private RedisTemplate<String,Product> redisTemplate;
	
	@Override
	public void addProduct(Product product){
		redisTemplate.opsForValue().set("product:"+product.getID(), product);
	}
	
	
	@Override
	public Product getProduct(Integer ID){
		Product p = redisTemplate.opsForValue().get("product:"+ID);
		return p;
	}

	@Override
	public void removeProduct(Integer ID) {
		redisTemplate.delete("product:"+ID);
	}


	@Override
	public void removeAllProduct() {
		
		Set<String> productKeys = redisTemplate.keys("product:*");
		
		String[] keys = new String[productKeys.size()];
		productKeys.toArray(keys);
		
		for(int i=0;i<keys.length;i++){
			redisTemplate.delete(keys[i]);
		}
		
	}
	
	
}
