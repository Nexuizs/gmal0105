package com.lzk.gmall.user.controller;

import com.lzk.gmall.user.bean.UmsMember;
import com.lzk.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getAllUser")
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMember =  userService.getAllUser();
        return umsMember;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
