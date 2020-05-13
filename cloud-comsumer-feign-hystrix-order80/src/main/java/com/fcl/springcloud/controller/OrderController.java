package com.fcl.springcloud.controller;

import com.fcl.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: FCL
 * @DateTime: 2020/5/13 14:21
 * @Description: TODO
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id")Integer id){
        return orderService.paymentInfo_ok(id);
    }

    @GetMapping("/order/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id")Integer id){
        return orderService.paymentInfo_timeout(id);
    }
}
