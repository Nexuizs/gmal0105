package com.lzk.gmall.bean.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AttrInfoAndValue implements Serializable {
    private Long id;
    private String attrName;
    private Long catalog3Id;
    private List<AttrValueDto> attrValueList;
}
