package com.lzk.gmall.service;

import com.lzk.gmall.bean.PmsBaseSaleAttr;
import com.lzk.gmall.bean.PmsProductSaleAttr;

import java.util.List;

public interface PmsProductSaleAttrService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsProductSaleAttr record);

    int insertSelective(PmsProductSaleAttr record);

    PmsProductSaleAttr selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductSaleAttr record);

    int updateByPrimaryKey(PmsProductSaleAttr record);

    List<PmsProductSaleAttr> selectBySpuId(Long spuId);

    List<PmsProductSaleAttr> selectSpuSaleAttrListCheckBySku(Long productId, Long skuId);
}
