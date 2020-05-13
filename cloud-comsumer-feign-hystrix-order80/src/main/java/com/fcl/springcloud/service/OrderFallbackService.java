package com.fcl.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 实现OrderService方法，统一异常处理
 */
@Component
public class OrderFallbackService implements OrderService{

    @Override
    public String paymentInfo_ok(Integer id) {
        return "--------- OrderFallbackService  paymentInfo_ok 哭";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "--------- OrderFallbackService  paymentInfo_timeout 哭";
    }
}
