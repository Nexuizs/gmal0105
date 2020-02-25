package com.lzk.gmall.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class PmsSkuAttrValue implements Serializable {
    /**
    * 编号
    */
    private Long id;

    /**
    * 属性id（冗余)
    */
    private Long attrId;

    /**
    * 属性值id
    */
    private Long valueId;

    /**
    * skuid
    */
    private Long skuId;

    private static final long serialVersionUID = 1L;
}