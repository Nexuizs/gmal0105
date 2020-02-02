package com.lzk.gmall.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class PmsBaseCatalog2 implements Serializable {
    /**
    * 编号
    */
    private Integer id;

    /**
    * 二级分类名称
    */
    private String name;

    /**
    * 一级分类编号
    */
    private Integer catalog1Id;

    private static final long serialVersionUID = 1L;
}