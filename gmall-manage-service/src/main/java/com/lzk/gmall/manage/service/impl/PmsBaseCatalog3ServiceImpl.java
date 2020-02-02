package com.lzk.gmall.manage.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.bean.PmsBaseCatalog3;
import com.lzk.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.lzk.gmall.service.PmsBaseCatalog3Service;

import java.util.List;

@Service
public class PmsBaseCatalog3ServiceImpl implements PmsBaseCatalog3Service{

    @Resource
    private PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pmsBaseCatalog3Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsBaseCatalog3 record) {
        return pmsBaseCatalog3Mapper.insert(record);
    }

    @Override
    public int insertSelective(PmsBaseCatalog3 record) {
        return pmsBaseCatalog3Mapper.insertSelective(record);
    }

    @Override
    public PmsBaseCatalog3 selectByPrimaryKey(Integer id) {
        return pmsBaseCatalog3Mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsBaseCatalog3 record) {
        return pmsBaseCatalog3Mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsBaseCatalog3 record) {
        return pmsBaseCatalog3Mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PmsBaseCatalog3> selectByCatalog2Id(Integer catalog2Id) {
        return pmsBaseCatalog3Mapper.selectByCatalog2Id(catalog2Id);
    }

}
