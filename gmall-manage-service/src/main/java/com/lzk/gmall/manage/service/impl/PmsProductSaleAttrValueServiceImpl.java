package com.lzk.gmall.manage.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.bean.PmsProductSaleAttrValue;
import com.lzk.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.lzk.gmall.service.PmsProductSaleAttrValueService;
@Service
public class PmsProductSaleAttrValueServiceImpl implements PmsProductSaleAttrValueService{

    @Resource
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsProductSaleAttrValueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsProductSaleAttrValue record) {
        return pmsProductSaleAttrValueMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsProductSaleAttrValue record) {
        return pmsProductSaleAttrValueMapper.insertSelective(record);
    }

    @Override
    public PmsProductSaleAttrValue selectByPrimaryKey(Long id) {
        return pmsProductSaleAttrValueMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsProductSaleAttrValue record) {
        return pmsProductSaleAttrValueMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsProductSaleAttrValue record) {
        return pmsProductSaleAttrValueMapper.updateByPrimaryKey(record);
    }

}
