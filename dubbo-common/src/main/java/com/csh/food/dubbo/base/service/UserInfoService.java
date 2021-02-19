package com.csh.food.dubbo.base.service;

import com.csh.food.dubbo.base.entity.UserInfoEntity;

import java.util.List;

public interface UserInfoService {
    List<UserInfoEntity> queryUserList();
}
