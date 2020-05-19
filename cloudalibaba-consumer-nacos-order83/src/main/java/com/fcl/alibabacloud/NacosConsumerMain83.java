package com.fcl.alibabacloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: FCL
 * @DateTime: 2020/5/19 9:28
 * @Description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerMain83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerMain83.class,args);
    }
}
