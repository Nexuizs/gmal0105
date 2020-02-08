package com.lzk.gmall.service;

import com.lzk.gmall.bean.PmsProductVertifyRecord;
public interface PmsProductVertifyRecordService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsProductVertifyRecord record);

    int insertSelective(PmsProductVertifyRecord record);

    PmsProductVertifyRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductVertifyRecord record);

    int updateByPrimaryKey(PmsProductVertifyRecord record);

}
