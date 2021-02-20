//package com.csh.food.pic.config.dubbo;
//
//import org.apache.dubbo.config.ProtocolConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DubboHessianConfig {
//    @Bean("hessian")
//    public ProtocolConfig restProtocolConfig(){
//        ProtocolConfig config = new ProtocolConfig();
//        config.setName("hessian");
//        config.setId("hessian");
//        config.setServer("jetty");
//        config.setPort(20887);
//        config.setAccepts(500);
//        config.setThreads(100);
//        return config;
//    }
//}
