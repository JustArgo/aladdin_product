package com.maiquan.aladdin_product;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maiquan.aladdin_product.domain.Product;
import com.maiquan.aladdin_product.domain.ProductDetail;
import com.maiquan.aladdin_product.service.IProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestProductService {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private RedisTemplate<String,Product> redisTemplate;
	
	@Autowired
	private RedisTemplate<String,ProductDetail> detailTemplate;
	
	/**
	 * 测试新增商品
	 */
	@Test
	public void testInsertProduct(){
		
		String[] status = new String[]{"UP#","DW#","DEL"};
		
		for(int i=222;i<=223;i++){
			Product product = new Product();
			product.setID(i);
			product.setBrandID(1);
			product.setCategoryID(1);
			product.setCollects(335);
			product.setCreateTime(new Date());
			product.setLimitCount(3);
			product.setMinusStock("GET");
			product.setPlatform("APP");
			product.setPrice(335L);
			product.setProductCode("234234");
			product.setProductName("小鞋");
			product.setSellCount(13);
			product.setSellDesc("毛衣");
			product.setSellType("NOR");
			product.setShortName("maoyi");
			product.setSortOrder(1);
			product.setStatus(status[i%3]);
			product.setSupplyID(324);
			product.setUid(234);
			product.setViews(332);
			product.setWeight(3L);
			productService.addProduct(product,"");
		}
		
	}
	
	/**
	 * 测试查找商品
	 */
	@Test
	public void testGetProduct(){
		
		Product p = productService.queryProduct(1,"");
		System.out.println(p);
		
	}
	
	/**
	 * 测试查找商品列表
	 */
	@Test
	public void testGetProductList(){
		
	}
	
	/**
	 * 测试查找指定状态的商品
	 */
	@Test
	public void testGetProductByStatus(){
		
	}
	
	/**
	 * 测试查找所有商品
	 */
	@Test
	public void testQueryProductList(){
		
	}
	
	/**
	 * 测试更新商品
	 */
	@Test
	public void testUpdateProduct(){
		
	}
	
	/**
	 * 测试删除商品
	 */
	@Test
	public void testDelProduct(){
		
	}
	
	/**
	 * 测试下架商品
	 */
	@Test
	public void testOffShelfProduct(){
		
	}
	
	/**
	 * 测试缓存商品到redis中
	 */
	@Test
	public void testAddProductToRedis(){
		
		Product p = new Product();
		p.setID(2344);
		
		redisTemplate.opsForValue().set("product:2344", p);
		//设置缓存超时 60秒
		redisTemplate.expire("product:2344", 60, TimeUnit.SECONDS);
		
	}
	
	/**
	 * 测试从redis中清除商品
	 */
	@Test
	public void testRemoveProductFromRedis(){
		
		Set<String> productKeys = redisTemplate.keys("product:*");
		
		String[] keys = new String[productKeys.size()];
		productKeys.toArray(keys);
		
		for(int i=0;i<keys.length;i++){
			redisTemplate.delete(keys[i]);
		}
		
	}
	
	/**
	 * 测试从redis中获取指定商品
	 */
	@Test
	public void testGetProductFromRedis(){
		
		Product p = redisTemplate.opsForValue().get("product:3");
		System.out.println(p);
		
	}
	
}

