package com.lzk.gmall.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class PmsBaseCatalog3 implements Serializable {
    /**
    * 编号
    */
    private Integer id;

    /**
    * 三级分类名称
    */
    private String name;

    /**
    * 二级分类编号
    */
    private Long catalog2Id;

    private static final long serialVersionUID = 1L;
}