package com.fcl.springcloud.order.service;

import com.fcl.springcloud.entitys.CommonResult;
import com.fcl.springcloud.entitys.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: FCL
 * @DateTime: 2020/5/12 8:56
 * @Description: TODO
 */
@FeignClient(value = "cloud-payment-service")
public interface OrderService {

    @GetMapping("/payment/getName/{id}")
    CommonResult<Payment> getName(@PathVariable("id") Integer id);
}
