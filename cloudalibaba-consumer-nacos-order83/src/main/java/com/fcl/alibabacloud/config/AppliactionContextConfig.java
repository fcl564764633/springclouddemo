package com.fcl.alibabacloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: FCL
 * @DateTime: 2020/5/19 9:33
 * @Description: TODO
 */
@Configuration
public class AppliactionContextConfig {

    @Bean //用ribbon 默认有负载均衡
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
