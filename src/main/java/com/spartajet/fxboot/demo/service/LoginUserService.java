package com.spartajet.fxboot.demo.service;

import com.spartajet.fxboot.demo.base.LoginUserInfo;
import org.springframework.stereotype.Service;

@Service
public interface LoginUserService {
    LoginUserInfo getUser(Integer id);
}
