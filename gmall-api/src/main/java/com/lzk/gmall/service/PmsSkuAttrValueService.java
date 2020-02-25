package com.lzk.gmall.service;

import com.lzk.gmall.bean.PmsSkuAttrValue;
public interface PmsSkuAttrValueService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuAttrValue record);

    int insertSelective(PmsSkuAttrValue record);

    PmsSkuAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSkuAttrValue record);

    int updateByPrimaryKey(PmsSkuAttrValue record);

}
