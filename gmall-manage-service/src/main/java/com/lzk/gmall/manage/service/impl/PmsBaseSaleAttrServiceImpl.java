package com.lzk.gmall.manage.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.bean.PmsBaseSaleAttr;
import com.lzk.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.lzk.gmall.service.PmsBaseSaleAttrService;

import java.util.List;

@Service
public class PmsBaseSaleAttrServiceImpl implements PmsBaseSaleAttrService{

    @Resource
    private PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsBaseSaleAttrMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsBaseSaleAttr record) {
        return pmsBaseSaleAttrMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsBaseSaleAttr record) {
        return pmsBaseSaleAttrMapper.insertSelective(record);
    }

    @Override
    public PmsBaseSaleAttr selectByPrimaryKey(Long id) {
        return pmsBaseSaleAttrMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsBaseSaleAttr record) {
        return pmsBaseSaleAttrMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsBaseSaleAttr record) {
        return pmsBaseSaleAttrMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PmsBaseSaleAttr> selectAll() {
        return pmsBaseSaleAttrMapper.selectAll();
    }

}
