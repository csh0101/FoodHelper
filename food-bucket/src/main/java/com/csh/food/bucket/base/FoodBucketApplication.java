package com.csh.food.bucket.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FoodBucketApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodBucketApplication.class,args);
    }
}
