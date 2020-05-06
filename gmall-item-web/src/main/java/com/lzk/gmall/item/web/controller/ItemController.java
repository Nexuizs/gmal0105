package com.lzk.gmall.item.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.lzk.gmall.bean.PmsProductSaleAttr;
import com.lzk.gmall.bean.PmsSkuInfo;
import com.lzk.gmall.bean.PmsSkuSaleAttrValue;
import com.lzk.gmall.service.PmsProductSaleAttrService;
import com.lzk.gmall.service.PmsSkuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        List<PmsProductSaleAttr> pmsProductSaleAttrList = pmsProductSaleAttrService.selectSpuSaleAttrListCheckBySku(pmsSkuInfo.getProductId(), skuId);
        HashMap<String, String> skuSaleAttrHash = new HashMap<>();
        List<PmsSkuInfo> pmsSkuInfoList = pmsSkuInfoService.getSkuSaleAttrValueListBySpu(pmsSkuInfo.getProductId());
        for (PmsSkuInfo skuInfo : pmsSkuInfoList) {
            String key = "";
            String value = skuInfo.getId().toString();
            List<PmsSkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
                key += pmsSkuSaleAttrValue.getSaleAttrValueId() + "|";
            }
            skuSaleAttrHash.put(key, value);
        }
        String skuSaleAttrHashJsonStr = JSON.toJSONString(skuSaleAttrHash);
        map.put("skuSaleAttrHashJsonStr", skuSaleAttrHashJsonStr);
        map.put("skuInfo", pmsSkuInfo);
        map.put("spuSaleAttrListCheckBySku", pmsProductSaleAttrList);
        return "item";
    }
}
