package com.fcl.alibabacloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: FCL
 * @DateTime: 2020/5/19 9:18
 * @Description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9002.class,args);
    }
}
