package com.csh.food.dubbo.service;

import com.csh.food.dubbo.entity.UserInfoEntity;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;

@Service(protocol = "dubbo",version = "1.0.0")
public class UserInfoProviderImpl implements UserInfoService {
    @Override
    public List<UserInfoEntity> queryUserList() {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUuid(1);
        userInfoEntity.setUserId(1);
        userInfoEntity.setUserName("陈适");
        List<UserInfoEntity> userInfoEntityList = new ArrayList<>();
        userInfoEntityList.add(userInfoEntity);
        return userInfoEntityList;
    }
}
