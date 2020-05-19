package com.example.demo.datasource;

import com.example.demo.model.TenantInfo;
import com.example.demo.service.ITenantInfoService;
import com.example.demo.utils.SpringContextUtils;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 动态数据源初始化
 *
 * @author 李嘉
 * @version 1.0
 * @Description 动态数据源初始化
 * @date 2020/5/19 00:08
 */
@Slf4j
@Configuration
public class DynamicDataSourceInit {

    @Autowired
    private ITenantInfoService tenantInfoService;

    @Bean
    public void initDataSource() {
        log.info("======初始化动态数据源=====");
        DynamicDataSource dynamicDataSource = (DynamicDataSource) SpringContextUtils.getBean("dynamicDataSource");
        HikariDataSource master = (HikariDataSource) SpringContextUtils.getBean("master");
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("master", master);

        List<TenantInfo> tenantList = tenantInfoService.list();
        for (TenantInfo tenantInfo : tenantList) {
            log.info(tenantInfo.toString());
            HikariDataSource dataSource = new HikariDataSource();
            dataSource.setDriverClassName(tenantInfo.getDatasourceDriver());
            dataSource.setJdbcUrl(tenantInfo.getDatasourceUrl());
            dataSource.setUsername(tenantInfo.getDatasourceUsername());
            dataSource.setPassword(tenantInfo.getDatasourcePassword());
            dataSource.setDataSourceProperties(master.getDataSourceProperties());
            dataSourceMap.put(tenantInfo.getTenantId(), dataSource);
        }
        // 设置数据源
        dynamicDataSource.setDataSources(dataSourceMap);
        /**
         * 必须执行此操作，才会重新初始化AbstractRoutingDataSource 中的 resolvedDataSources，也只有这样，动态切换才会起效
         */
        dynamicDataSource.afterPropertiesSet();
    }
}
