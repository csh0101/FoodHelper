package com.csh.food.controller;

import com.csh.food.dubbo.base.entity.UserInfoEntity;
import com.csh.food.dubbo.base.service.UserInfoService;
import com.csh.food.dubbo.base.vo.R;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class TestConsumerController {
    @Reference
    private UserInfoService userInfoService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public R getList(){
        List<UserInfoEntity> userInfoEntityList = userInfoService.queryUserList();
        return R.ok().put("data",userInfoEntityList);
    }
}
