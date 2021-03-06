package com.fcl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: FCL
 * @DateTime: 2020/5/15 16:32
 * @Description: TODO
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String port;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return port +" : "+configInfo;
    }
}
