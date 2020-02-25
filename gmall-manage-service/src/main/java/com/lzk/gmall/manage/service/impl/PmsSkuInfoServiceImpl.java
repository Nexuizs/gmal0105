package com.lzk.gmall.manage.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.bean.PmsSkuAttrValue;
import com.lzk.gmall.bean.PmsSkuImage;
import com.lzk.gmall.bean.PmsSkuInfo;
import com.lzk.gmall.bean.PmsSkuSaleAttrValue;
import com.lzk.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.lzk.gmall.manage.mapper.PmsSkuImageMapper;
import com.lzk.gmall.manage.mapper.PmsSkuInfoMapper;
import com.lzk.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.lzk.gmall.service.PmsSkuInfoService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PmsSkuInfoServiceImpl implements PmsSkuInfoService{

    @Resource
    private PmsSkuInfoMapper pmsSkuInfoMapper;

    @Resource
    private PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Resource
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Resource
    private PmsSkuImageMapper pmsSkuImageMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsSkuInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(PmsSkuInfo record) {
        record.setProductId(record.getSpuId());
        int i = pmsSkuInfoMapper.insert(record);
        Long skuId = record.getId();
        if(i > 0){
            List<PmsSkuAttrValue> pmsSkuAttrValueList = record.getSkuAttrValueList();
            for (PmsSkuAttrValue pmsSkuAttrValue : pmsSkuAttrValueList) {
                pmsSkuAttrValue.setSkuId(skuId);
                int j = pmsSkuAttrValueMapper.insert(pmsSkuAttrValue);
                if(j == 0){
                    return 0;
                }
            }
            List<PmsSkuSaleAttrValue> skuSaleAttrValueList = record.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
                pmsSkuSaleAttrValue.setSkuId(skuId);
                int z = pmsSkuSaleAttrValueMapper.insert(pmsSkuSaleAttrValue);
                if(z == 0){
                    return 0;
                }
            }
            List<PmsSkuImage> skuImageList = record.getSkuImageList();
            for (PmsSkuImage pmsSkuImage : skuImageList) {
                pmsSkuImage.setSkuId(skuId);
                pmsSkuImage.setProductImgId(pmsSkuImage.getSpuImgId());
                int y = pmsSkuImageMapper.insert(pmsSkuImage);
                if(y == 0){
                    return 0;
                }
            }
        }
        return 1;
    }

    @Override
    public int insertSelective(PmsSkuInfo record) {
        return pmsSkuInfoMapper.insertSelective(record);
    }

    @Override
    public PmsSkuInfo selectByPrimaryKey(Long id) {
        return pmsSkuInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsSkuInfo record) {
        return pmsSkuInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsSkuInfo record) {
        return pmsSkuInfoMapper.updateByPrimaryKey(record);
    }

}
