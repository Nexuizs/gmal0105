package com.lzk.gmall.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class PmsProductVertifyRecord implements Serializable {
    private Long id;

    private Integer productId;

    private Date createTime;

    /**
    * 审核人
    */
    private String vertifyMan;

    private Integer status;

    /**
    * 反馈详情
    */
    private String detail;

    private static final long serialVersionUID = 1L;
}