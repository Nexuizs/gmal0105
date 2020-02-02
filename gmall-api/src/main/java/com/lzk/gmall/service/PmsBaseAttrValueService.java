package com.lzk.gmall.service;

import com.lzk.gmall.bean.PmsBaseAttrValue;
import com.lzk.gmall.bean.dto.AttrInfoAndValue;

import java.util.List;

public interface PmsBaseAttrValueService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsBaseAttrValue record);

    int insertSelective(PmsBaseAttrValue record);

    PmsBaseAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBaseAttrValue record);

    int updateByPrimaryKey(PmsBaseAttrValue record);

    Integer saveAttrInfo(AttrInfoAndValue attrInfoAndValue, Integer judgeId);

    List<PmsBaseAttrValue> selectByAttrId(Long attrId);
}
