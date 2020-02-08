package com.lzk.gmall.service;

import com.lzk.gmall.bean.PmsProductImage;

import java.util.List;

public interface PmsProductImageService{


    int deleteByPrimaryKey(Integer id);

    int insert(PmsProductImage record);

    int insertSelective(PmsProductImage record);

    PmsProductImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PmsProductImage record);

    int updateByPrimaryKey(PmsProductImage record);

    List<PmsProductImage> selectBySpuId(Long spuId);
}
