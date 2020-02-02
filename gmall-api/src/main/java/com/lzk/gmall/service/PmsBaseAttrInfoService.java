package com.lzk.gmall.service;

import com.lzk.gmall.bean.PmsBaseAttrInfo;
import com.lzk.gmall.bean.dto.AttrInfoAndValue;

import java.util.List;

public interface PmsBaseAttrInfoService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsBaseAttrInfo record);

    int insertSelective(PmsBaseAttrInfo record);

    PmsBaseAttrInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBaseAttrInfo record);

    int updateByPrimaryKey(PmsBaseAttrInfo record);

    List<PmsBaseAttrInfo> selectByCatalog3Id(Integer catalog3Id);

    Long saveAttrInfo(AttrInfoAndValue attrInfoAndValue);
}
