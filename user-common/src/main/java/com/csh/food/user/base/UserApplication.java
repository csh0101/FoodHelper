package com.csh.food.user.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserApplication {
    //负责公共吊顶导航菜单配置中心的开发与维护
    //负责统一网关的开发与维护
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
