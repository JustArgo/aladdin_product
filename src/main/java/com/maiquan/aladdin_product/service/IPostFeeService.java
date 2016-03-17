package com.maiquan.aladdin_product.service;

public interface IPostFeeService {

	Long calcPostFee(Integer productID, Integer buyNum, Integer countryID, Integer provinceID, Integer cityID, Integer districtID, String requestID);
}
