package com.spartajet.fxboot.demo.service.impl;

import com.spartajet.fxboot.demo.base.LoginUserInfo;
import com.spartajet.fxboot.demo.mapper.LoginUserInfoMapper;
import com.spartajet.fxboot.demo.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service

public class LoginUserServiceImpl implements LoginUserService {
    @Autowired
    LoginUserInfoMapper userMapper;
    public LoginUserInfo getUser(Integer id) {
        LoginUserInfo user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
