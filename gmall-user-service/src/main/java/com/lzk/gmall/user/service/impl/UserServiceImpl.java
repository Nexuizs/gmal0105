package com.lzk.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzk.gmall.bean.UmsMember;
import com.lzk.gmall.user.mapper.UserMapper;
import com.lzk.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMemberList = userMapper.selectAllUser();
        return umsMemberList;
    }
}
