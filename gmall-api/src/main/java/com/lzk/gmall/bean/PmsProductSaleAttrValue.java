package com.lzk.gmall.bean;

import java.beans.Transient;
import java.io.Serializable;
import lombok.Data;

@Data
public class PmsProductSaleAttrValue implements Serializable {
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
    * 销售属性值名称
    */
    private String saleAttrValueName;

    /**
     * 默认被选中
     */
    String isChecked;

    private static final long serialVersionUID = 1L;
}