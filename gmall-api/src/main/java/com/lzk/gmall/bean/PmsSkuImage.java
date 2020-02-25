package com.lzk.gmall.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class PmsSkuImage implements Serializable {
    /**
    * 编号
    */
    private Long id;

    /**
    * 商品id
    */
    private Long skuId;

    /**
    * 图片名称（冗余）
    */
    private String imgName;

    /**
    * 图片路径(冗余)
    */
    private String imgUrl;

    /**
    * 商品图片id
    */
    private Long productImgId;

    private Long spuImgId;

    /**
    * 是否默认
    */
    private String isDefault;

    private static final long serialVersionUID = 1L;
}