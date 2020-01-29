package com.lzk.gmall.mapper;

import com.lzk.gmall.bean.UmsMember;

import java.util.List;

public interface UserMapper {

    List<UmsMember> selectAllUser();

    int deleteByPrimaryKey(Long id);

    int insert(UmsMember record);

    int insertSelective(UmsMember record);

    UmsMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMember record);

    int updateByPrimaryKey(UmsMember record);
}
