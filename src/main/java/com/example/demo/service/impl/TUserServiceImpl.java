package com.example.demo.service.impl;

import com.example.demo.model.TUser;
import com.example.demo.dao.TUserMapper;
import com.example.demo.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Lij
 * @since 2020-05-19
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
