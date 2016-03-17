package com.maiquan.aladdin_product.mapper;

import com.maiquan.aladdin_product.domain.ProductFreight;

public interface ProductFreightMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(ProductFreight record);

    int insertSelective(ProductFreight record);

    ProductFreight selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(ProductFreight record);

    int updateByPrimaryKey(ProductFreight record);
    
    ProductFreight selectByProductID(Integer productID);
}