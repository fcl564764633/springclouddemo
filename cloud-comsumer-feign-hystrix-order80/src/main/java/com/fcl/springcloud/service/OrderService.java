package com.fcl.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: FCL
 * @DateTime: 2020/5/13 14:22
 * @Description: TODO
 */
@Component
//fallback = OrderFallbackService.class   统一处理   解耦  代码量少
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = OrderFallbackService.class)
public interface OrderService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id")Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id")Integer id);
}
