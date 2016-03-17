package com.maiquan.aladdin_product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.maiquan.aladdin_product.domain.FreightTpl;
import com.maiquan.aladdin_product.domain.FreightTplExcept;
import com.maiquan.aladdin_product.domain.Product;
import com.maiquan.aladdin_product.domain.ProductFreight;
import com.maiquan.aladdin_product.mapper.FreightTplExceptMapper;
import com.maiquan.aladdin_product.mapper.FreightTplMapper;
import com.maiquan.aladdin_product.mapper.ProductFreightMapper;
import com.maiquan.aladdin_product.mapper.ProductMapper;
import com.maiquan.aladdin_product.service.IPostFeeService;
import com.maiquan.aladdin_product.util.LogUtil;

public class PostFeeServiceImpl implements IPostFeeService{

	@Autowired
	private ProductFreightMapper productFreightMapper;
	
	@Autowired
	private FreightTplMapper freightTplMapper;
	
	@Autowired
	private FreightTplExceptMapper freightTplExceptMapper;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public Long calcPostFee(Integer productID, Integer buyNum, Integer countryID,
			Integer provinceID, Integer cityID, Integer districtID,
			String requestID) {

		System.out.println(productID+" "+buyNum+" "+countryID+" "+provinceID+" "+cityID+" "+districtID+" "+requestID);
		
		LogUtil.logInput("邮费计算微服务","calcPostFee",requestID,productID,countryID,cityID,districtID);
		
		Long postFee = 0L;
		ProductFreight productFreight = productFreightMapper.selectByProductID(productID);
		System.out.println("判断productFreight是否为空---"+productFreight);
		if(productFreight!=null){
			
			Product product = productMapper.selectByPrimaryKey(productID);
			Long price = product.getPrice();
			Long totalPrice = price*buyNum;
			System.out.println("totalPrice--"+totalPrice);
			System.out.println("判断prouduct是否为空---"+product);
			FreightTpl freightTpl = freightTplMapper.selectByPrimaryKey(productFreight.getFreightTplID());
			System.out.println("判断freightTpl是否为空---"+freightTpl);
			String freightType = freightTpl.getFreightType();
			System.out.println("判断freightType是否为空---"+freightType);
			//获得指定的地区 
			List<FreightTplExcept> exceptAddresses = freightTplExceptMapper.selectNoDeletedByTplID(freightTpl.getID());
			System.out.println("判断exceptAddresses是否为空---"+exceptAddresses.size());
			//如果参数对应的地区 属于额外指定的地区 返回该对象
			FreightTplExcept tplExcept = matchAddress(exceptAddresses,countryID,provinceID,cityID,districtID);
			System.out.println("判断是否返回匹配的地区---"+tplExcept);
			//先计算物品的重量 单位KG
			Long weight = ((product.getWeight()*buyNum+999)/1000);
			switch(freightType){
				case "NOT":
					break;
				case "NOE":
					if(tplExcept!=null){
						//如果tplExcept(指定地区)启用满额包邮
						if(tplExcept.getFullStatus().equals("USE") && tplExcept.getFullSum()<=totalPrice*100){
							break;
						}
						postFee = (long) (tplExcept.getFirstFreight()+(weight-1)*tplExcept.getSecFreight());
						System.out.println("判断NOE的邮费---"+postFee);
					}
					break;
				case "BUY":
					break;
				case "NAT":
					//如果启用满额包邮
					if(freightTpl.getFullStatus().equals("USE") && freightTpl.getFullSum()<=totalPrice*100){
						System.out.println("NAT 商品:"+productID+"按满额包邮算");
						break;
					}
					postFee = (long) (freightTpl.getFirstFreight()+(weight-1)*freightTpl.getSecFreight());
					System.out.println("NAT 商品:"+productID+" 不包邮 的邮费---"+postFee);
					break;
				case "NAE":
					
					if(tplExcept!=null){
						if(tplExcept.getFullStatus().equals("USE") && tplExcept.getFullSum()<=totalPrice*100){
							System.out.println("NAE 商品:"+productID+"按满额包邮算(指定地区)");
							break;
						}
						postFee = (long) (tplExcept.getFirstFreight()+(weight-1)*tplExcept.getSecFreight());
						System.out.println("NAE 按指定地区算  不包邮 ---"+postFee);
					}else{
						if(freightTpl.getFullStatus().equals("USE") && freightTpl.getFullSum()<=totalPrice*100){
							System.out.println("NAE 按满额包邮算");
							break;
						}
						postFee = (long) (freightTpl.getFirstFreight()+(weight-1)*freightTpl.getSecFreight());
						System.out.println("NAE 按正常算法算");
					}
					break;
			}
		}
		
		LogUtil.logOutput("邮费计算微服务","calcPostFee",requestID,postFee);
		
		return postFee;
	}

	private FreightTplExcept matchAddress(List<FreightTplExcept> exceptsAddress,Integer countryID,Integer provinceID,Integer cityID,Integer districtID){
		FreightTplExcept tplExcept = null;
		if(exceptsAddress!=null){
			for(FreightTplExcept exceptAdd:exceptsAddress){
				if(exceptAdd.getDistrictID()!=null && districtID!=null){
					if(districtID.equals(exceptAdd.getDistrictID())){
						tplExcept = exceptAdd;
						return exceptAdd;
					}
				}else if(exceptAdd.getCityID()!=null  && cityID!=null){
					if(cityID.equals(exceptAdd.getCityID())){
						tplExcept = exceptAdd;
						return exceptAdd;
					}
				}else if(exceptAdd.getProvinceID()!=null  && provinceID!=null){
					if(provinceID.equals(exceptAdd.getProvinceID())){
						tplExcept = exceptAdd;
						return exceptAdd;
					}
				}else if(exceptAdd.getCountryID()!=null && countryID!=null){
					if(countryID.equals(exceptAdd.getCountryID())){
						tplExcept = exceptAdd;
						return exceptAdd;
					}
				}
				
			}
		}
		return tplExcept;
	}

}
