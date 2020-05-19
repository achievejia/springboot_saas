package com.example.demo.controller;


import com.example.demo.model.CustomResult;
import com.example.demo.model.PeopleConfig;
import com.example.demo.service.IPeopleConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 人员配置 前端控制器
 * </p>
 *
 * @author Lij
 * @since 2020-05-19
 */
@RestController
@RequestMapping("/peopleConfig")
public class PeopleConfigController {

    @Autowired
    private IPeopleConfigService peopleConfigService;

    @GetMapping("/info")
    public CustomResult<PeopleConfig> getInfo() {
        List<PeopleConfig> list = peopleConfigService.list();
        return CustomResult.Ok(list);
    }
}
