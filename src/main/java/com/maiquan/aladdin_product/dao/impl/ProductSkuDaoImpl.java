package com.maiquan.aladdin_product.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.maiquan.aladdin_product.dao.IProductSkuDao;
import com.maiquan.aladdin_product.domain.ProductSku;

@Repository
public class ProductSkuDaoImpl implements IProductSkuDao{

	@Autowired
	private RedisTemplate<String,ProductSku> redisTemplate;
	
	@Override
	public void addProductSku(ProductSku sku) {
		redisTemplate.opsForValue().set("sku:"+sku.getID()+":"+sku.getProductID(), sku);
	}

	@Override
	public ProductSku getProductSku(Integer ID) {
		Set<String> keys = redisTemplate.keys("sku:"+ID+":*");
		if(keys.size()>0){
			String[] keyArr = new String[keys.size()];
			keys.toArray(keyArr);
			return redisTemplate.opsForValue().get(keyArr[0]);
		}
		return null;
	}

	@Override
	public void addProductSkuListWithSameProductID(List<ProductSku> skus){
		
		//什么时候调用该方法 更新的时候
		
		Integer[] keys = new Integer[skus.size()];
		for(int i=0;i<keys.length;i++){
			keys[i] = skus.get(i).getID();
			redisTemplate.opsForValue().set("sku:"+keys[i]+":"+skus.get(0).getProductID(),skus.get(i));
		}
		
		redisTemplate.opsForHash().put("skupid:"+skus.get(0).getProductID(),"keys",keys);

	}
	
	@Override
	public List<ProductSku> getProductSkuByProductID(Integer productID){
		
		List<ProductSku> skuList = new ArrayList<ProductSku>();
		Integer[] keys = (Integer[])redisTemplate.opsForHash().get("skupid:"+productID, "keys");
		if(keys!=null && keys.length>0){
			Set<String> skuKeys = redisTemplate.keys("sku:*:"+productID);
			if(skuKeys.size()==keys.length){
				for(int i=0;i<keys.length;i++){
					skuList.add(redisTemplate.opsForValue().get("sku:"+keys[i]+":"+productID));
				}
			}
			
		}
		return skuList;
		
	}

	@Override
	public void removeProductSku(Integer productSkuID) {
		
		Set<String> skus = redisTemplate.keys("sku:"+productSkuID+":*");
		String[] keys = new String[skus.size()];
		if(keys.length!=0){
			skus.toArray(keys);
			redisTemplate.delete(keys[0]);
			
			//同时移除对应的skupid:pid
			String pid = keys[0].substring(keys[0].lastIndexOf(":")+1);
			redisTemplate.delete("skupid:"+pid);
		}
	}

	@Override
	public void removeAllProductSku() {
		Set<String> skus = redisTemplate.keys("sku:*:*");
		String[] keys = new String[skus.size()];
		skus.toArray(keys);
		for(int i=0;i<keys.length;i++){
			redisTemplate.delete(keys[i]);
		}
	}
}
