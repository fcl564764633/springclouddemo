package com.fcl.springcloud.configurationBeans;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: FCL
 * @DateTime: 2020/5/13 9:27
 * @Description: TODO 配置日志打印
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        //NONE:默认  不显示任何日志
        //BASIC：仅记录请求方法,URL，响应状态码及执行时间
        //HEADERS：除了BASIC中的信息外，还有请求和响应的头信息
        //FULL：除了HEADERS中信息外，还有请求和响应的正文和元数据
        return Logger.Level.FULL;//
    }
}
