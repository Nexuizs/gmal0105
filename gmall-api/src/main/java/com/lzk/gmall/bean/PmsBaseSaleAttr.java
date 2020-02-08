package com.lzk.gmall.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class PmsBaseSaleAttr implements Serializable {
    /**
    * 编号
    */
    private Long id;

    /**
    * 销售属性名称
    */
    private String name;

    private static final long serialVersionUID = 1L;
}