package com.lzk.gmall.manage.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.manage.mapper.PmsProductInfoMapper;
import com.lzk.gmall.bean.PmsProductInfo;
import com.lzk.gmall.service.PmsProductInfoService;

import java.util.List;

@Service
public class PmsProductInfoServiceImpl implements PmsProductInfoService{

    @Resource
    private PmsProductInfoMapper pmsProductInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsProductInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Long insert(PmsProductInfo record) {
        int i = pmsProductInfoMapper.insert(record);
        if(i > 0){
            return record.getId();
        }
        return 0L;
    }

    @Override
    public int insertSelective(PmsProductInfo record) {
        return pmsProductInfoMapper.insertSelective(record);
    }

    @Override
    public PmsProductInfo selectByPrimaryKey(Long id) {
        return pmsProductInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsProductInfo record) {
        return pmsProductInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsProductInfo record) {
        return pmsProductInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PmsProductInfo> selectByCatalog3Id(Long catalog3Id) {
        return pmsProductInfoMapper.selectByCatalog3Id(catalog3Id);
    }

}
