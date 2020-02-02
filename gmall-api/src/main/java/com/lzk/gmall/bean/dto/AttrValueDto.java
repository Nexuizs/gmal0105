package com.lzk.gmall.bean.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AttrValueDto implements Serializable {
    private String valueName;
    private Boolean edit;
}
