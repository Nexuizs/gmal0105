package com.lzk.gmall.service;

import com.lzk.gmall.bean.PmsBaseCatalog1;

import java.util.List;

public interface PmsBaseCatalog1Service{


    int deleteByPrimaryKey(Integer id);

    int insert(PmsBaseCatalog1 record);

    int insertSelective(PmsBaseCatalog1 record);

    PmsBaseCatalog1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PmsBaseCatalog1 record);

    int updateByPrimaryKey(PmsBaseCatalog1 record);

    List<PmsBaseCatalog1> getCatalog1();
}
