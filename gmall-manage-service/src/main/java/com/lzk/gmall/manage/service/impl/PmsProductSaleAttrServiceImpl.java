package com.lzk.gmall.manage.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.bean.PmsProductSaleAttrValue;
import com.lzk.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.lzk.gmall.bean.PmsProductSaleAttr;
import com.lzk.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.lzk.gmall.service.PmsProductSaleAttrService;

import java.util.List;

@Service
public class PmsProductSaleAttrServiceImpl implements PmsProductSaleAttrService{

    @Resource
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Resource
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsProductSaleAttrMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsProductSaleAttr record) {
        return pmsProductSaleAttrMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsProductSaleAttr record) {
        return pmsProductSaleAttrMapper.insertSelective(record);
    }

    @Override
    public PmsProductSaleAttr selectByPrimaryKey(Long id) {
        return pmsProductSaleAttrMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsProductSaleAttr record) {
        return pmsProductSaleAttrMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsProductSaleAttr record) {
        return pmsProductSaleAttrMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PmsProductSaleAttr> selectBySpuId(Long spuId) {
        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductSaleAttrMapper.selectBySpuId(spuId);
        for (PmsProductSaleAttr pmsProductSaleAttr : pmsProductSaleAttrs) {
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues = pmsProductSaleAttrValueMapper.selectByProductIdAndSaleAttrId(pmsProductSaleAttr.getProductId(), pmsProductSaleAttr.getSaleAttrId());
            pmsProductSaleAttr.setSpuSaleAttrValueList(pmsProductSaleAttrValues);
        }
        return pmsProductSaleAttrs;
    }

    @Override
    public List<PmsProductSaleAttr> selectSpuSaleAttrListCheckBySku(Long productId, Long skuId) {
        return pmsProductSaleAttrMapper.selectSpuSaleAttrListCheckBySku(productId, skuId);
    }
}
