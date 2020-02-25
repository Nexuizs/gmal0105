package com.lzk.gmall.service;

import com.lzk.gmall.bean.PmsSkuImage;
public interface PmsSkuImageService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuImage record);

    int insertSelective(PmsSkuImage record);

    PmsSkuImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSkuImage record);

    int updateByPrimaryKey(PmsSkuImage record);

}
