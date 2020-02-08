package com.lzk.gmall.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PmsProductSaleAttr implements Serializable {
    /**
    * id
    */
    private Long id;

    /**
    * 商品id
    */
    private Long productId;

    /**
    * 销售属性id
    */
    private Long saleAttrId;

    /**
    * 销售属性名称(冗余)
    */
    private String saleAttrName;

    /**
     * 销售属性值
     */
    private List<PmsProductSaleAttrValue> spuSaleAttrValueList;

    private static final long serialVersionUID = 1L;
}