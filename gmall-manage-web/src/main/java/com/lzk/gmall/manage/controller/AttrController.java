package com.lzk.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lzk.gmall.bean.PmsBaseAttrInfo;
import com.lzk.gmall.bean.PmsBaseAttrValue;
import com.lzk.gmall.bean.dto.AttrInfoAndValue;
import com.lzk.gmall.service.PmsBaseAttrInfoService;
import com.lzk.gmall.service.PmsBaseAttrValueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AttrController {

    @Reference
    PmsBaseAttrInfoService pmsBaseAttrInfoService;

    @Reference
    PmsBaseAttrValueService pmsBaseAttrValueService;

    /**
     * 查看平台属性
     * @param catalog3Id
     * @return
     */
    @RequestMapping("attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(Integer catalog3Id){
        return pmsBaseAttrInfoService.selectByCatalog3Id(catalog3Id);
    }

    /**
     * 添加平台属性与属性值
     * @param attrInfoAndValue
     * @return
     */
    @RequestMapping("saveAttrInfo")
    public String saveAttrInfo(@RequestBody AttrInfoAndValue attrInfoAndValue){
        Integer judgeId = 2;//2为修改
        Long id = attrInfoAndValue.getId();
        Long i = pmsBaseAttrInfoService.saveAttrInfo(attrInfoAndValue);
        if(i > 0){
            if(id == null){
                attrInfoAndValue.setId(i);
                judgeId = 1;//1为保存
            }
            Integer j = pmsBaseAttrValueService.saveAttrInfo(attrInfoAndValue, judgeId);
            if(j > 0){
                return "success";
            }
            return "error";
        }else {
            return "error";
        }
    }

    /**
     * 获取平台属性值
     * @param attrId
     * @return
     */
    @RequestMapping("getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(Long attrId){
        return pmsBaseAttrValueService.selectByAttrId(attrId);
    }
}
