package com.lzk.gmall.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PmsBaseAttrInfo implements Serializable {
    /**
    * 编号
    */
    private Long id;

    /**
    * 属性名称
    */
    private String attrName;

    private Long catalog3Id;

    /**
    * 启用：1 停用：0
    */
    private String isEnabled;

    private List<PmsBaseAttrValue> attrValueList;

    private static final long serialVersionUID = 1L;
}