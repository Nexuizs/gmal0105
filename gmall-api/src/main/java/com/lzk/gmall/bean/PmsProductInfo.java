package com.lzk.gmall.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PmsProductInfo implements Serializable {
    /**
    * 商品id
    */
    private Long id;

    /**
    * 商品名称
    */
    private String productName;

    /**
    * 商品描述(后台简述）
    */
    private String description;

    /**
    * 三级分类id
    */
    private Long catalog3Id;

    /**
    * 品牌id
    */
    private Long tmId;

    /**
     * 图片数据源信息
     */
    private List<PmsProductImage> spuImageList;

    /**
     * 销售属性
     */
    private List<PmsProductSaleAttr> spuSaleAttrList;

    private static final long serialVersionUID = 1L;
}