package com.lzk.gmall.manage.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.bean.PmsBaseAttrInfo;
import com.lzk.gmall.bean.PmsBaseAttrValue;
import com.lzk.gmall.bean.dto.AttrInfoAndValue;
import com.lzk.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.lzk.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.lzk.gmall.service.PmsBaseAttrInfoService;

import java.util.List;

@Service
public class PmsBaseAttrInfoServiceImpl implements PmsBaseAttrInfoService{

    @Resource
    private PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Resource
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsBaseAttrInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsBaseAttrInfo record) {
        return pmsBaseAttrInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsBaseAttrInfo record) {
        return pmsBaseAttrInfoMapper.insertSelective(record);
    }

    @Override
    public PmsBaseAttrInfo selectByPrimaryKey(Long id) {
        return pmsBaseAttrInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsBaseAttrInfo record) {
        return pmsBaseAttrInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsBaseAttrInfo record) {
        return pmsBaseAttrInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PmsBaseAttrInfo> selectByCatalog3Id(Integer catalog3Id) {
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.selectByCatalog3Id(catalog3Id);
        for (PmsBaseAttrInfo pmsBaseAttrInfo : pmsBaseAttrInfos) {
            List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.selectByAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrInfo.setAttrValueList(pmsBaseAttrValues);
        }
        return pmsBaseAttrInfos;
    }

    @Override
    public Long saveAttrInfo(AttrInfoAndValue attrInfoAndValue) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setAttrName(attrInfoAndValue.getAttrName());
        pmsBaseAttrInfo.setCatalog3Id(attrInfoAndValue.getCatalog3Id());
        Long id = attrInfoAndValue.getId();
        if(id == null){
            Integer i = pmsBaseAttrInfoMapper.insert(pmsBaseAttrInfo);
            if(i > 0){
                Long infoId = pmsBaseAttrInfo.getId();
                return infoId;
            }
        }else{
            pmsBaseAttrInfo.setId(id);
            int i = pmsBaseAttrInfoMapper.updateByPrimaryKeySelective(pmsBaseAttrInfo);
            if(i > 0){
                return 1L;
            }
        }
        return 0L;
    }

}
