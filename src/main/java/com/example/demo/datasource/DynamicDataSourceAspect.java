package com.example.demo.datasource;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.CustomResult;
import com.example.demo.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 动态数据源切面拦截
 *
 * @author 李嘉
 * @version 1.0
 * @Description 动态数据源切面拦截
 * @date 2020/5/19 00:29
 */
@Slf4j
@Aspect
@Component
@Order(1) // 请注意：这里order一定要小于tx:annotation-driven的order，即先执行DynamicDataSourceAspectAdvice切面，再执行事务切面，才能获取到最终的数据源
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DynamicDataSourceAspect {

    @Around("execution(* com.example.demo.controller.*.*(..)) || execution(* com.example.demo.*.*(..))")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Object result = null;
        try {
            HttpServletRequest request = sra.getRequest();
            HttpSession session = sra.getRequest().getSession(true);
            String tenantId = (String)session.getAttribute("tenantId");
            if (StringUtil.isEmpty(tenantId)) {
                tenantId = request.getParameter("tenantId");
            }

            log.info("当前租户Id:{}", tenantId);
            if (!StringUtil.isEmpty(tenantId)) {
                DynamicDataSourceContextHolder.setDataSourceKey(tenantId);
                result = jp.proceed();
            } else {
                result = CustomResult.Fail("查询失败，当前租户信息未取到，请联系技术专家！");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = CustomResult.Fail("系统异常，请联系技术专家！");
        } finally {
            DynamicDataSourceContextHolder.clearDataSourceKey();
        }
        return result;
    }

}
