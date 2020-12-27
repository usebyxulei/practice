package com.example.ant.practice.service.impl;

import com.example.ant.practice.entity.User;
import com.example.ant.practice.mapper.UserMapper;
import com.example.ant.practice.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-11-14
 */
@Service
@Primary
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
