package com.maiquan.aladdin.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.maiquan.aladdin.dao.IProductSkuDao;
import com.maiquan.aladdin.domain.ProductSku;

@Repository
public class ProductSkuDaoImpl implements IProductSkuDao{

	@Autowired
	private RedisTemplate<String,ProductSku> redisTemplate;
	
	@Override
	public void addProductSku(ProductSku sku) {
		
		redisTemplate.opsForList().leftPush("sku:"+sku.getID()+":"+sku.getProductID(), sku);
		
	}

	@Override
	public ProductSku getProductSku(Integer ID) {
		return redisTemplate.opsForList().leftPop("sku:"+ID);
	}

	@Override
	public void addProductSkuListWithSameProductID(List<ProductSku> skus){
		Integer pid = skus.get(0).getProductID();
		for(int i=0;i<skus.size();i++){
			redisTemplate.opsForList().rightPush("skupid:"+pid, skus.get(i));
		}
	}
	
	@Override
	public List<ProductSku> getProductSkuByProductID(Integer productID){
		Long size = redisTemplate.opsForList().size("skupid:"+productID);
		return redisTemplate.opsForList().range("skupid:"+productID,0,size-1);
	}
}
