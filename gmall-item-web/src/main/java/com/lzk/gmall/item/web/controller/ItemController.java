package com.lzk.gmall.item.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lzk.gmall.bean.PmsProductSaleAttr;
import com.lzk.gmall.bean.PmsSkuInfo;
import com.lzk.gmall.service.PmsProductSaleAttrService;
import com.lzk.gmall.service.PmsSkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ItemController {

    @Reference
    PmsSkuInfoService pmsSkuInfoService;

    @Reference
    PmsProductSaleAttrService pmsProductSaleAttrService;

    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("数组循环" + i);
        }
        modelMap.put("list", list);
        modelMap.put("hello", "hellp thymeleaf");
        return "index";
    }

    @RequestMapping("{skuId}.html")
    public String item(@PathVariable Long skuId, ModelMap map){
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoService.getSkuById(skuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrList = pmsProductSaleAttrService.selectBySpuId(pmsSkuInfo.getProductId());
        map.put("skuInfo", pmsSkuInfo);
        map.put("spuSaleAttrListCheckBySku", pmsProductSaleAttrList);
        return "item";
    }
}
