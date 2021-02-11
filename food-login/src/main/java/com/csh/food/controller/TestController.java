package com.csh.food.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
    @Value("${server.port}")
    String port;

    @GetMapping(value = "/csh/common/sayHello")
    public String sayHellow(){
        return "Hello! I anm from "+port;
    }
}
