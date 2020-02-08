package com.lzk.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lzk.gmall.bean.*;
import com.lzk.gmall.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import util.PmsUploadUtil;

import java.util.List;

@RestController
@CrossOrigin
public class SpuController {

    @Reference
    PmsProductInfoService pmsProductInfoService;

    @Reference
    PmsBaseSaleAttrService pmsBaseSaleAttrService;

    @Reference
    PmsProductSaleAttrService pmsProductSaleAttrService;

    @Reference
    PmsProductSaleAttrValueService pmsProductSaleAttrValueService;

    @Reference
    PmsProductImageService pmsProductImageService;

    /**
     * 获取spu
     * @param catalog3Id
     * @return
     */
    @RequestMapping("spuList")
    public List<PmsProductInfo> spuList(Long catalog3Id){
        return pmsProductInfoService.selectByCatalog3Id(catalog3Id);
    }

    /**
     * 获取销售属性选项
     * @return
     */
    @RequestMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        return pmsBaseSaleAttrService.selectAll();
    }

    /**
     * 添加销售属性与属性值
     * @param pmsProductInfo
     * @return
     */
    @RequestMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        Long i = pmsProductInfoService.insert(pmsProductInfo);
        if(i > 0){
            List<PmsProductSaleAttr> spuSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
            for (PmsProductSaleAttr pmsProductSaleAttr : spuSaleAttrList) {
                pmsProductSaleAttr.setProductId(i);
                int j = pmsProductSaleAttrService.insert(pmsProductSaleAttr);
                if(j > 0){
                    List<PmsProductSaleAttrValue> spuSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
                    for (PmsProductSaleAttrValue pmsProductSaleAttrValue : spuSaleAttrValueList) {
                        pmsProductSaleAttrValue.setProductId(i);
                        int z = pmsProductSaleAttrValueService.insert(pmsProductSaleAttrValue);
                        if(z == 0){
                            return "error";
                        }
                    }
                }
            }
            List<PmsProductImage> spuImageList = pmsProductInfo.getSpuImageList();
            for (PmsProductImage pmsProductImage : spuImageList) {
                pmsProductImage.setProductId(i);
                int a = pmsProductImageService.insert(pmsProductImage);
                if(a == 0){
                    return "error";
                }
            }
        }
        return "error";
    }

    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        String imgUrl = PmsUploadUtil.uploadImage(multipartFile);
        System.out.println(imgUrl);
        return imgUrl;
    }

    @RequestMapping("spuSaleAttrList")
    public List<PmsProductSaleAttr> spuSaleAttrList(Long spuId){
        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductSaleAttrService.selectBySpuId(spuId);
        return pmsProductSaleAttrs;
    }

    @RequestMapping("spuImageList")
    public List<PmsProductImage> spuImageList(Long spuId){
        return pmsProductImageService.selectBySpuId(spuId);
    }
}
