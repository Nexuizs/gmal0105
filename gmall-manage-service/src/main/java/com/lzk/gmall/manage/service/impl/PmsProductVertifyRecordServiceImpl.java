package com.lzk.gmall.manage.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.bean.PmsProductVertifyRecord;
import com.lzk.gmall.manage.mapper.PmsProductVertifyRecordMapper;
import com.lzk.gmall.service.PmsProductVertifyRecordService;
@Service
public class PmsProductVertifyRecordServiceImpl implements PmsProductVertifyRecordService{

    @Resource
    private PmsProductVertifyRecordMapper pmsProductVertifyRecordMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsProductVertifyRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsProductVertifyRecord record) {
        return pmsProductVertifyRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsProductVertifyRecord record) {
        return pmsProductVertifyRecordMapper.insertSelective(record);
    }

    @Override
    public PmsProductVertifyRecord selectByPrimaryKey(Long id) {
        return pmsProductVertifyRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsProductVertifyRecord record) {
        return pmsProductVertifyRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsProductVertifyRecord record) {
        return pmsProductVertifyRecordMapper.updateByPrimaryKey(record);
    }

}
