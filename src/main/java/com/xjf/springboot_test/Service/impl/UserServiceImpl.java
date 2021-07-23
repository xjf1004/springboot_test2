package com.xjf.springboot_test.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xjf.springboot_test.Mapper.UserMapper;
import com.xjf.springboot_test.Service.UserService;
import com.xjf.springboot_test.bean.User;
import org.springframework.stereotype.Service;

/**
 * @author Refrain_ouc
 * @create 2021-07-21 10:30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
