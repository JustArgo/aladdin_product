package com.maiquan.aladdin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.maiquan.aladdin.domain.ProductSku;
import com.maiquan.aladdin.mapper.ProductSkuMapper;
import com.maiquan.aladdin.service.IProductSkuService;

public class ProductSkuServiceImpl implements IProductSkuService{

	@Autowired
	private ProductSkuMapper productSkuMapper;
	
	@Override
	public ProductSku getSkuByID(Integer ID) {
		return productSkuMapper.selectByPrimaryKey(ID);
	}

	@Override
	public List<ProductSku> getSkuByProductID(Integer productID) {
		return productSkuMapper.selectByProductID(productID);
	}

}
