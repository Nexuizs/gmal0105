package com.lzk.gmall.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class PmsBaseAttrValue implements Serializable {
    /**
    * 编号
    */
    private Long id;

    /**
    * 属性值名称
    */
    private String valueName;

    /**
    * 属性id
    */
    private Long attrId;

    /**
    * 启用：1 停用：0 1
    */
    private String isEnabled;

    private static final long serialVersionUID = 1L;
}