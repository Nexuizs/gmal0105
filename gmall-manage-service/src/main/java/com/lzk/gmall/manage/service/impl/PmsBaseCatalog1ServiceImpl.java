package com.lzk.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.bean.PmsBaseCatalog1;
import com.lzk.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.lzk.gmall.service.PmsBaseCatalog1Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PmsBaseCatalog1ServiceImpl implements PmsBaseCatalog1Service{

    @Autowired
    private PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pmsBaseCatalog1Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsBaseCatalog1 record) {
        return pmsBaseCatalog1Mapper.insert(record);
    }

    @Override
    public int insertSelective(PmsBaseCatalog1 record) {
        return pmsBaseCatalog1Mapper.insertSelective(record);
    }

    @Override
    public PmsBaseCatalog1 selectByPrimaryKey(Integer id) {
        return pmsBaseCatalog1Mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsBaseCatalog1 record) {
        return pmsBaseCatalog1Mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsBaseCatalog1 record) {
        return pmsBaseCatalog1Mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.getCatalog1();
    }

}
