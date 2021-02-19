package com.csh.food.gateway.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FoodGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodGateWayApplication.class,args);
    }
}
