package com.fcl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: FCL
 * @DateTime: 2020/5/13 14:02
 * @Description: TODO 增加hystrix 断路器 例子
 */
@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker //开启断路器
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }
}
