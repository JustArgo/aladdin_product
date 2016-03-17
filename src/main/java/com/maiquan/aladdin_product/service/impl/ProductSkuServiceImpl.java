package com.maiquan.aladdin_product.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.maiquan.aladdin_product.dao.IProductSkuDao;
import com.maiquan.aladdin_product.domain.ProductSku;
import com.maiquan.aladdin_product.domain.ProductSkuAttr;
import com.maiquan.aladdin_product.mapper.ProductAttrMapper;
import com.maiquan.aladdin_product.mapper.ProductAttrValueMapper;
import com.maiquan.aladdin_product.mapper.ProductSkuAttrMapper;
import com.maiquan.aladdin_product.mapper.ProductSkuMapper;
import com.maiquan.aladdin_product.service.IProductSkuService;
import com.maiquan.aladdin_product.util.LogUtil;

public class ProductSkuServiceImpl implements IProductSkuService{

	@Autowired
	private ProductSkuMapper productSkuMapper;
	
	@Autowired
	private ProductAttrMapper productAttrMapper;
	
	@Autowired
	private ProductAttrValueMapper productAttrValueMapper;
	
	@Autowired
	private ProductSkuAttrMapper productSkuAttrMapper;
	
	@Autowired
	private IProductSkuDao productSkuDao;
	
	@Override
	public ProductSku getSkuByID(Integer ID, String requestID) {
		
		LogUtil.logInput("商品Sku微服务", "getSkuByID", requestID, ID);
		
		ProductSku productSku = productSkuMapper.selectByPrimaryKey(ID);
		
		LogUtil.logOutput("商品Sku微服务", "getSkuByID", requestID, productSku);
		
		return productSku;
	}

	@Override
	public List<ProductSku> getSkuByProductID(Integer productID, String requestID) {
		
		LogUtil.logInput("商品Sku微服务", "getSkuByProductID", requestID, productID);
		
		//先去redis里面找 如果找不到
		List<ProductSku> skus = productSkuDao.getProductSkuByProductID(productID);
		
		if(skus.size()==0){
			//redis没有找到 从数据库里面找
			skus = productSkuMapper.selectByProductID(productID);
			//存储到redis中
			productSkuDao.addProductSkuListWithSameProductID(skus);
			
		}
		
		LogUtil.logOutput("商品Sku微服务", "getSkuByProductID", requestID, skus);
		
		return skus;
		
		
	}

	@Override
	public List<String> getSkuStr(Integer skuID, String requestID) {
		
		LogUtil.logInput("商品Sku微服务", "getSkuStr", requestID, skuID);
		
		List<String> skuStrs = new ArrayList<String>();	 
		
		List<ProductSkuAttr> skuAttrs = productSkuAttrMapper.selectBySkuID(skuID);
		
		//System.out.println("getSkuStr:---- skuID:"+skuID+" skuAttrs.size()"+skuAttrs.size());
		
		for(int i=0;i<skuAttrs.size();i++){
			String attrName  = productAttrMapper.selectAttrNameByID(skuAttrs.get(i).getAttrID());
			String attrValue = productAttrValueMapper.selectAttrValueByID(skuAttrs.get(i).getAttrValueID());
			
			skuStrs.add(attrName+":"+attrValue);
		}
		
		LogUtil.logOutput("商品Sku微服务", "getSkuStr", requestID, skuStrs);
		
		return skuStrs;
	}

	@Override
	public List<ProductSkuAttr> getSkuAttrBySkuID(Integer skuID, String requestID) {

		LogUtil.logInput("商品Sku微服务", "getSkuAttrBySkuID", requestID, skuID);
		
		List<ProductSkuAttr> productSkuAttrs = productSkuAttrMapper.selectBySkuID(skuID);
		
		LogUtil.logOutput("商品Sku微服务", "getSkuAttrBySkuID", requestID, productSkuAttrs);
		
		return productSkuAttrs;
	}

	@Override
	public int updateSku(ProductSku productSku, String requestID) {
		
		LogUtil.logInput("商品sku微服务","updateSku",requestID,productSku);
		
		if(productSku!=null){
			productSkuMapper.updateByPrimaryKeySelective(productSku);
			productSkuDao.removeProductSku(productSku.getID());
		}
		
		LogUtil.logOutput("商品sku微服务","updateSku",requestID,"无");
		
		return 0;
	}

}
