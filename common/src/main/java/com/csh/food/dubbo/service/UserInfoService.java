package com.csh.food.dubbo.service;

import com.csh.food.dubbo.entity.UserInfoEntity;

import java.util.List;

public interface UserInfoService {
    List<UserInfoEntity> queryUserList();
}
