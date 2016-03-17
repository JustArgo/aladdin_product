package com.maiquan.aladdin_product.mapper;

import com.maiquan.aladdin_product.domain.FreightTpl;

public interface FreightTplMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(FreightTpl record);

    int insertSelective(FreightTpl record);

    FreightTpl selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(FreightTpl record);

    int updateByPrimaryKey(FreightTpl record);
}