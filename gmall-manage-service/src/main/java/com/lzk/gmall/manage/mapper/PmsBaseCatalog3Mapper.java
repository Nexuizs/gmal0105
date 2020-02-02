package com.lzk.gmall.manage.mapper;

import com.lzk.gmall.bean.PmsBaseCatalog3;

import java.util.List;

public interface PmsBaseCatalog3Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PmsBaseCatalog3 record);

    int insertSelective(PmsBaseCatalog3 record);

    PmsBaseCatalog3 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PmsBaseCatalog3 record);

    int updateByPrimaryKey(PmsBaseCatalog3 record);

    List<PmsBaseCatalog3> selectByCatalog2Id(Integer catalog2Id);
}