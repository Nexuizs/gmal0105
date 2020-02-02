package com.lzk.gmall.manage.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.bean.PmsBaseAttrInfo;
import com.lzk.gmall.bean.dto.AttrInfoAndValue;
import com.lzk.gmall.bean.dto.AttrValueDto;
import com.lzk.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.lzk.gmall.bean.PmsBaseAttrValue;
import com.lzk.gmall.service.PmsBaseAttrValueService;

import java.util.List;

@Service
public class PmsBaseAttrValueServiceImpl implements PmsBaseAttrValueService{

    @Resource
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsBaseAttrValueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsBaseAttrValue record) {
        return pmsBaseAttrValueMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsBaseAttrValue record) {
        return pmsBaseAttrValueMapper.insertSelective(record);
    }

    @Override
    public PmsBaseAttrValue selectByPrimaryKey(Long id) {
        return pmsBaseAttrValueMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsBaseAttrValue record) {
        return pmsBaseAttrValueMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsBaseAttrValue record) {
        return pmsBaseAttrValueMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer saveAttrInfo(AttrInfoAndValue attrInfoAndValue, Integer judgeId) {
        List<AttrValueDto> list = attrInfoAndValue.getAttrValueList();
        if(judgeId == 1){
            for (AttrValueDto attrValueDto : list) {
                PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
                pmsBaseAttrValue.setAttrId(attrInfoAndValue.getId());
                pmsBaseAttrValue.setValueName(attrValueDto.getValueName());
                Integer i = pmsBaseAttrValueMapper.insert(pmsBaseAttrValue);
                if(i == 0){
                    return 0;
                }
            }
        }
        if(judgeId == 2){
            int a = pmsBaseAttrValueMapper.deleteByAttrId(attrInfoAndValue.getId());
            if(a == 0){
                return a;
            }
            for (AttrValueDto attrValueDto : list) {
                PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
                pmsBaseAttrValue.setAttrId(attrInfoAndValue.getId());
                pmsBaseAttrValue.setValueName(attrValueDto.getValueName());
                Integer i = pmsBaseAttrValueMapper.insert(pmsBaseAttrValue);
                if(i == 0){
                    return 0;
                }
            }
        }
        return 1;
    }

    @Override
    public List<PmsBaseAttrValue> selectByAttrId(Long attrId) {
        return pmsBaseAttrValueMapper.selectByAttrId(attrId);
    }

}
