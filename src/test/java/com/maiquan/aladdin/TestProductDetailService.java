package com.maiquan.aladdin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maiquan.aladdin.service.IProductDetailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:local/applicationContext.xml")
public class TestProductDetailService {

	@Autowired
	private IProductDetailService productDetailService;
	
	@Test
	public void testGetSegment(){
		
		String descSeg = productDetailService.getProductDescSegment(1, 3);
		System.out.println(descSeg);
	}
	
}
