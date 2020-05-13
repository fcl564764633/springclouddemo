package com.fcl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: FCL
 * @DateTime: 2020/5/13 14:20
 * @Description: TODO
 */
@EnableFeignClients
@EnableEurekaClient  //不加这个注解  貌似新版springcloud 也可以注册到服务中心
@SpringBootApplication
public class ComsumerHystrixOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ComsumerHystrixOrderMain80.class,args);
    }
}
