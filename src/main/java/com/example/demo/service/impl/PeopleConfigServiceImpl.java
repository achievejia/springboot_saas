package com.example.demo.service.impl;

import com.example.demo.model.PeopleConfig;
import com.example.demo.dao.PeopleConfigMapper;
import com.example.demo.service.IPeopleConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人员配置 服务实现类
 * </p>
 *
 * @author Lij
 * @since 2020-05-19
 */
@Service
public class PeopleConfigServiceImpl extends ServiceImpl<PeopleConfigMapper, PeopleConfig> implements IPeopleConfigService {

}
