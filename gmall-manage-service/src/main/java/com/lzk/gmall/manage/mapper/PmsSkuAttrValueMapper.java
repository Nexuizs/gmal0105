package com.lzk.gmall.manage.mapper;

import com.lzk.gmall.bean.PmsSkuAttrValue;

public interface PmsSkuAttrValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuAttrValue record);

    int insertSelective(PmsSkuAttrValue record);

    PmsSkuAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSkuAttrValue record);

    int updateByPrimaryKey(PmsSkuAttrValue record);
}