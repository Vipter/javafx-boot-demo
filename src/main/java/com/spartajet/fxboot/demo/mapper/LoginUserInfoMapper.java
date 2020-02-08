package com.spartajet.fxboot.demo.mapper;

import com.spartajet.fxboot.demo.base.LoginUserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginUserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(LoginUserInfo record);

    int insertSelective(LoginUserInfo record);

    LoginUserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(LoginUserInfo record);

    int updateByPrimaryKey(LoginUserInfo record);
}