package com.lzk.gmall.manage.mapper;

import com.lzk.gmall.bean.PmsProductImage;

import java.util.List;

public interface PmsProductImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PmsProductImage record);

    int insertSelective(PmsProductImage record);

    PmsProductImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PmsProductImage record);

    int updateByPrimaryKey(PmsProductImage record);

    List<PmsProductImage> selectBySpuId(Long spuId);
}