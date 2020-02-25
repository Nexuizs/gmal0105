package com.lzk.gmall.manage.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.bean.PmsSkuImage;
import com.lzk.gmall.manage.mapper.PmsSkuImageMapper;
import com.lzk.gmall.service.PmsSkuImageService;
@Service
public class PmsSkuImageServiceImpl implements PmsSkuImageService{

    @Resource
    private PmsSkuImageMapper pmsSkuImageMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsSkuImageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsSkuImage record) {
        return pmsSkuImageMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsSkuImage record) {
        return pmsSkuImageMapper.insertSelective(record);
    }

    @Override
    public PmsSkuImage selectByPrimaryKey(Long id) {
        return pmsSkuImageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsSkuImage record) {
        return pmsSkuImageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsSkuImage record) {
        return pmsSkuImageMapper.updateByPrimaryKey(record);
    }

}
