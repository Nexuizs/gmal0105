package com.lzk.gmall.manage.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.bean.PmsSkuAttrValue;
import com.lzk.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.lzk.gmall.service.PmsSkuAttrValueService;
@Service
public class PmsSkuAttrValueServiceImpl implements PmsSkuAttrValueService{

    @Resource
    private PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsSkuAttrValueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsSkuAttrValue record) {
        return pmsSkuAttrValueMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsSkuAttrValue record) {
        return pmsSkuAttrValueMapper.insertSelective(record);
    }

    @Override
    public PmsSkuAttrValue selectByPrimaryKey(Long id) {
        return pmsSkuAttrValueMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsSkuAttrValue record) {
        return pmsSkuAttrValueMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsSkuAttrValue record) {
        return pmsSkuAttrValueMapper.updateByPrimaryKey(record);
    }

}
