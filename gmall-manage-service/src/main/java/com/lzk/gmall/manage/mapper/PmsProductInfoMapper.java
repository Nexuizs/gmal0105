package com.lzk.gmall.manage.mapper;

import com.lzk.gmall.bean.PmsProductInfo;

import java.util.List;

public interface PmsProductInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductInfo record);

    int insertSelective(PmsProductInfo record);

    PmsProductInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductInfo record);

    int updateByPrimaryKey(PmsProductInfo record);

    List<PmsProductInfo> selectByCatalog3Id(Long catalog3Id);
}