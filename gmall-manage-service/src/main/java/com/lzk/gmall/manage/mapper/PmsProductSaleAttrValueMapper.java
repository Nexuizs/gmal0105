package com.lzk.gmall.manage.mapper;

import com.lzk.gmall.bean.PmsProductSaleAttrValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductSaleAttrValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductSaleAttrValue record);

    int insertSelective(PmsProductSaleAttrValue record);

    PmsProductSaleAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductSaleAttrValue record);

    int updateByPrimaryKey(PmsProductSaleAttrValue record);

    List<PmsProductSaleAttrValue> selectByProductIdAndSaleAttrId(@Param("productId") Long productId, @Param("saleAttrId") Long saleAttrId);
}