package com.lzk.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lzk.gmall.bean.PmsBaseCatalog1;
import com.lzk.gmall.bean.PmsBaseCatalog2;
import com.lzk.gmall.bean.PmsBaseCatalog3;
import com.lzk.gmall.service.PmsBaseCatalog1Service;
import com.lzk.gmall.service.PmsBaseCatalog2Service;
import com.lzk.gmall.service.PmsBaseCatalog3Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CatalogController {

    @Reference
    PmsBaseCatalog1Service pmsBaseCatalog1Service;

    @Reference
    PmsBaseCatalog2Service pmsBaseCatalog2Service;

    @Reference
    PmsBaseCatalog3Service pmsBaseCatalog3Service;

    @RequestMapping("getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1(){
        return pmsBaseCatalog1Service.getCatalog1();
    }

    @RequestMapping("getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(@RequestParam Integer catalog1Id){
        return pmsBaseCatalog2Service.selectByCatalog1Id(catalog1Id);
    }

    @RequestMapping("getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(@RequestParam Integer catalog2Id){
        return pmsBaseCatalog3Service.selectByCatalog2Id(catalog2Id);
    }
}
