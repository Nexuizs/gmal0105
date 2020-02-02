package com.lzk.gmall.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class PmsBaseCatalog1 implements Serializable {
    /**
    * 编号
    */
    private Integer id;

    /**
    * 分类名称
    */
    private String name;

    private static final long serialVersionUID = 1L;
}