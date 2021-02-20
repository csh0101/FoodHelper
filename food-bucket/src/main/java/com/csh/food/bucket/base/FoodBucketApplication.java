package com.csh.food.bucket.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.csh.food.bucket")
@EnableDiscoveryClient
public class FoodBucketApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodBucketApplication.class,args);
    }
}
