package com.lzk.gmall.user.controller;

import com.lzk.gmall.bean.UmsMember;
import com.lzk.gmall.bean.UmsMemberReceiveAddress;
import com.lzk.gmall.service.UmsMemberReceiveAddressService;
import com.lzk.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UmsMemberReceiveAddressService umsMemberReceiveAddressService;

    @RequestMapping("/getAllUser")
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMember = userService.getAllUser();
        return umsMember;
    }

    @RequestMapping("/index")
    public String index(){
        return "index5";
    }

    @RequestMapping("/selectByMemberId")
    public List<UmsMemberReceiveAddress> selectByMemberId(Long memberId){
        return umsMemberReceiveAddressService.selectByMemberId(memberId);
    }
}
