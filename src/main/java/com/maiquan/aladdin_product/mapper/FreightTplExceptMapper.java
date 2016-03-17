package com.maiquan.aladdin_product.mapper;

import java.util.List;

import com.maiquan.aladdin_product.domain.FreightTplExcept;

public interface FreightTplExceptMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(FreightTplExcept record);

    int insertSelective(FreightTplExcept record);

    FreightTplExcept selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(FreightTplExcept record);

    int updateByPrimaryKey(FreightTplExcept record);
    
    List<FreightTplExcept> selectByTplID(Integer tplID);
    
    List<FreightTplExcept> selectNoDeletedByTplID(Integer tplID);
}