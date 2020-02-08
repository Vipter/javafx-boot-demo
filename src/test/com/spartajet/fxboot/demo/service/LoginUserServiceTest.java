package com.spartajet.fxboot.demo.service;

import com.spartajet.fxboot.demo.base.LoginUserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoginUserServiceTest {
    @Autowired
    LoginUserService userService;
    @Test
    public void getUser() {
        LoginUserInfo user = userService.getUser(1);
        System.out.println(user.getUserName());
    }
}