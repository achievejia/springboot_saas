package com.example.demo.controller;


import com.example.demo.datasource.DynamicDataSource;
import com.example.demo.datasource.DynamicDataSourceContextHolder;
import com.example.demo.model.CustomResult;
import com.example.demo.model.TenantInfo;
import com.example.demo.service.ITenantInfoService;
import com.example.demo.utils.CustomUtil;
import com.example.demo.utils.DateUtil;
import com.example.demo.utils.ResultEnum;
import com.example.demo.utils.SpringContextUtils;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lij
 * @since 2020-05-19
 */
@Slf4j
@RestController
@RequestMapping("/tenantInfo")
public class TenantInfoController {

    @Autowired
    private ITenantInfoService tenantInfoService;

    @GetMapping("/info")
    public CustomResult<TenantInfo> getInfo() {
        List<TenantInfo> list = tenantInfoService.list();
        return CustomResult.Ok(list);
    }

    @GetMapping("/save")
    public CustomResult<?> saveInfo() {
        TenantInfo tenantInfo = new TenantInfo();
        tenantInfo.setTenantId(CustomUtil.GenerateID());
        tenantInfo.setTenantName("动态新增");
        tenantInfo.setDatasourceUrl("jdbc:mysql://172.22.198.41:33306/saas_job?serverTimezone=Asia/Shanghai&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull");
        tenantInfo.setDatasourceUsername("saas_job");
        tenantInfo.setDatasourcePassword("ddiIE0wdkkdkj42019");
        tenantInfo.setDatasourceDriver("com.mysql.cj.jdbc.Driver");
        tenantInfo.setStatus(true);
        tenantInfo.setCreateTime(DateUtil.getCurrent());
        tenantInfo.setUpdateTime(DateUtil.getCurrent());
        boolean b = tenantInfoService.save(tenantInfo);
        if (b) {
            log.info("======初始化动态数据源=====");
            DynamicDataSource dynamicDataSource = (DynamicDataSource) SpringContextUtils.getBean("dynamicDataSource");
            HikariDataSource master = (HikariDataSource) SpringContextUtils.getBean("master");
            Map<Object, Object> dataSourceMap = new HashMap<>();
            dataSourceMap.put("master", master);

            List<TenantInfo> tenantList = tenantInfoService.list();
            for (TenantInfo tenantInfos : tenantList) {
                log.info(tenantInfos.getTenantId() + "     " + tenantInfos.getTenantName());
                HikariDataSource dataSource = new HikariDataSource();
                dataSource.setDriverClassName(tenantInfos.getDatasourceDriver());
                dataSource.setJdbcUrl(tenantInfos.getDatasourceUrl());
                dataSource.setUsername(tenantInfos.getDatasourceUsername());
                dataSource.setPassword(tenantInfos.getDatasourcePassword());
                dataSource.setDataSourceProperties(master.getDataSourceProperties());
                dataSourceMap.put(tenantInfos.getTenantId(), dataSource);
            }
            // 设置数据源
            dynamicDataSource.setDataSources(dataSourceMap);
            /**
             * 必须执行此操作，才会重新初始化AbstractRoutingDataSource 中的 resolvedDataSources，也只有这样，动态切换才会起效
             */
            dynamicDataSource.afterPropertiesSet();
        }
        return CustomResult.Build(b, b ? ResultEnum.Success.getIndex() : ResultEnum.Fail.getIndex());
    }
}
