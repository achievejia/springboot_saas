package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.CustomResult;
import com.example.demo.model.TUser;
import com.example.demo.service.ITUserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Lij
 * @since 2020-05-19
 */
@RestController
@RequestMapping("/tUser")
public class TUserController {

    @Autowired
    private ITUserService userService;

    @GetMapping("/info")
    public CustomResult<TUser> getInfo() {
        List<TUser> userList = userService.list();
        return CustomResult.Ok(userList);
    }
}
