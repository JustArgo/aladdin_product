package com.maiquan.aladdin.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.maiquan.aladdin.dao.IProductDao;
import com.maiquan.aladdin.domain.Product;

@Repository
public class ProductDaoImpl implements IProductDao{

	@Autowired
	private RedisTemplate<String,Product> redisTemplate;
	
	@Override
	public void addProduct(Product product){
		System.out.println("begin to add product use redis");
		redisTemplate.opsForList().leftPush(product.getID()+"", product);
		System.out.println("end to add product");
	}
	
	
	@Override
	public Product getProduct(Integer ID){
		System.out.println("begin to get product use redis");
		return redisTemplate.opsForList().leftPop(ID+"");
	}
	
	
	
}
