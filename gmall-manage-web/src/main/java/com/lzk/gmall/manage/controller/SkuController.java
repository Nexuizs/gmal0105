package com.lzk.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lzk.gmall.bean.PmsSkuInfo;
import com.lzk.gmall.service.PmsSkuInfoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SkuController {

    @Reference
    PmsSkuInfoService pmsSkuInfoService;

    @RequestMapping("saveSkuInfo")
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo){
        if(pmsSkuInfo.getSkuDefaultImg() == null){
            pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
        }
        int i = pmsSkuInfoService.insert(pmsSkuInfo);
        if(i > 0){
            return "success";
        }
        return "error";
    }
}
