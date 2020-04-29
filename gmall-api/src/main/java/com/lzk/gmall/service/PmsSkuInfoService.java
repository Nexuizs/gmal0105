package com.lzk.gmall.service;

import com.lzk.gmall.bean.PmsSkuInfo;
public interface PmsSkuInfoService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuInfo record);

    int insertSelective(PmsSkuInfo record);

    PmsSkuInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSkuInfo record);

    int updateByPrimaryKey(PmsSkuInfo record);

    PmsSkuInfo getSkuById(Long skuId);
}
