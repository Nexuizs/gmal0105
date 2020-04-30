package com.lzk.gmall.manage.mapper;

import com.lzk.gmall.bean.PmsProductSaleAttr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductSaleAttrMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductSaleAttr record);

    int insertSelective(PmsProductSaleAttr record);

    PmsProductSaleAttr selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductSaleAttr record);

    int updateByPrimaryKey(PmsProductSaleAttr record);

    List<PmsProductSaleAttr> selectBySpuId(Long spuId);

    List<PmsProductSaleAttr> selectSpuSaleAttrListCheckBySku(@Param("productId") Long productId, @Param("skuId") Long skuId);
}