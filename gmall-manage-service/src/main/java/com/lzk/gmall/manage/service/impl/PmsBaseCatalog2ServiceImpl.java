package com.lzk.gmall.manage.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.bean.PmsBaseCatalog2;
import com.lzk.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.lzk.gmall.service.PmsBaseCatalog2Service;

import java.util.List;

@Service
public class PmsBaseCatalog2ServiceImpl implements PmsBaseCatalog2Service{

    @Resource
    private PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pmsBaseCatalog2Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsBaseCatalog2 record) {
        return pmsBaseCatalog2Mapper.insert(record);
    }

    @Override
    public int insertSelective(PmsBaseCatalog2 record) {
        return pmsBaseCatalog2Mapper.insertSelective(record);
    }

    @Override
    public PmsBaseCatalog2 selectByPrimaryKey(Integer id) {
        return pmsBaseCatalog2Mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsBaseCatalog2 record) {
        return pmsBaseCatalog2Mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsBaseCatalog2 record) {
        return pmsBaseCatalog2Mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PmsBaseCatalog2> selectByCatalog1Id(Integer catalog1Id) {
        return pmsBaseCatalog2Mapper.selectByCatalog1Id(catalog1Id);
    }

}
