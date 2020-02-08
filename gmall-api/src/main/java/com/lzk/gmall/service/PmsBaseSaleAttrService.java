package com.lzk.gmall.service;

import com.lzk.gmall.bean.PmsBaseSaleAttr;

import java.util.List;

public interface PmsBaseSaleAttrService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsBaseSaleAttr record);

    int insertSelective(PmsBaseSaleAttr record);

    PmsBaseSaleAttr selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBaseSaleAttr record);

    int updateByPrimaryKey(PmsBaseSaleAttr record);

    List<PmsBaseSaleAttr> selectAll();
}
