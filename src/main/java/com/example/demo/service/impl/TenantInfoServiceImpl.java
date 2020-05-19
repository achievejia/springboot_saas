package com.example.demo.service.impl;

import com.example.demo.model.TenantInfo;
import com.example.demo.dao.TenantInfoMapper;
import com.example.demo.service.ITenantInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lij
 * @since 2020-05-19
 */
@Service
public class TenantInfoServiceImpl extends ServiceImpl<TenantInfoMapper, TenantInfo> implements ITenantInfoService {

}
