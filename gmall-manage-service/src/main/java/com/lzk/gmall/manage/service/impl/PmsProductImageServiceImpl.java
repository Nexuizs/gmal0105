package com.lzk.gmall.manage.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.bean.PmsProductImage;
import com.lzk.gmall.manage.mapper.PmsProductImageMapper;
import com.lzk.gmall.service.PmsProductImageService;

import java.util.List;

@Service
public class PmsProductImageServiceImpl implements PmsProductImageService{

    @Resource
    private PmsProductImageMapper pmsProductImageMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pmsProductImageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsProductImage record) {
        return pmsProductImageMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsProductImage record) {
        return pmsProductImageMapper.insertSelective(record);
    }

    @Override
    public PmsProductImage selectByPrimaryKey(Integer id) {
        return pmsProductImageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsProductImage record) {
        return pmsProductImageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsProductImage record) {
        return pmsProductImageMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PmsProductImage> selectBySpuId(Long spuId) {
        return pmsProductImageMapper.selectBySpuId(spuId);
    }

}
