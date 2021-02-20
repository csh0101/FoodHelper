package com.csh.food.pic.base;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.csh.food.pic"} )
@EnableDubbo
public class FoodPicApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodPicApplication.class,args);
    }
}
