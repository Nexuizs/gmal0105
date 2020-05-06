package com.lzk.gmall.service;

import com.lzk.gmall.bean.PmsSkuInfo;

import java.util.List;

public interface PmsSkuInfoService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuInfo record);

    int insertSelective(PmsSkuInfo record);

    PmsSkuInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSkuInfo record);

    int updateByPrimaryKey(PmsSkuInfo record);

    PmsSkuInfo getSkuById(Long skuId);

    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(Long productId);
}
