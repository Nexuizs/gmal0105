package com.lzk.gmall.service;

import com.lzk.gmall.bean.PmsProductSaleAttrValue;
public interface PmsProductSaleAttrValueService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsProductSaleAttrValue record);

    int insertSelective(PmsProductSaleAttrValue record);

    PmsProductSaleAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductSaleAttrValue record);

    int updateByPrimaryKey(PmsProductSaleAttrValue record);

}
