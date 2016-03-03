package com.maiquan.aladdin;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maiquan.aladdin.domain.ProductSku;
import com.maiquan.aladdin.service.IProductVoService;
import com.maiquan.aladdin.vo.ProductVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:local/applicationContext.xml")
public class TestProductVoService {

	@Autowired
	private IProductVoService productVoService;
	
	@Test
	public void testGetProductVo(){
		
		ProductVo pvo = productVoService.getProductVo(1);
		System.out.println(pvo.getProduct());
		System.out.println(pvo.getComment());
		List<ProductSku> skus = pvo.getSkus();
		for(int i=0;i<skus.size();i++){
			System.out.println(skus.get(i));
		}
	}
	
}
