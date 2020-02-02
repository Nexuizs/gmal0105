package com.lzk.gmall.manage.mapper;

import com.lzk.gmall.bean.PmsBaseAttrValue;

import java.util.List;

public interface PmsBaseAttrValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsBaseAttrValue record);

    int insertSelective(PmsBaseAttrValue record);

    PmsBaseAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBaseAttrValue record);

    int updateByPrimaryKey(PmsBaseAttrValue record);

    List<PmsBaseAttrValue> selectByAttrId(Long attrId);

    int deleteByAttrId(Long id);
}