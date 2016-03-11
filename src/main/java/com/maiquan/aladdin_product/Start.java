package com.maiquan.aladdin_product;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
	
	public static void main(String[] args) throws Exception{
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext-product.xml" });
		context.start();
		System.out.println("商品微服务启动");
		while(true){
			Thread.sleep(1000);
		}
		
	}
	
}
