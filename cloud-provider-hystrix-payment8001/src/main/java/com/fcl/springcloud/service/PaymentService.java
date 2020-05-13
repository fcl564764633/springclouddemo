package com.fcl.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: FCL
 * @DateTime: 2020/5/13 14:08
 * @Description: TODO
 */
@Service
public class PaymentService {

    public String paymentInfo_ok(Integer id){
        return "线程池 ："+Thread.currentThread().getName() + "paymentInfo_ok "+ id + "成功^_^" ;
    }
    @HystrixCommand(fallbackMethod = "paymentFallback_timeout",commandProperties ={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String paymentInfo_timeout(Integer id){
        System.out.println("进来真正方法");
        int number = 5;
        try {
            // int age = 10/0; 一样报错
            TimeUnit.SECONDS.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池 ："+Thread.currentThread().getName() + "paymentInfo_timeout "+ id + "超时（秒）"+ number;
    }
    //兜底方法   运行异常，超时，都会让服务降级  降级后执行的方法
    public String paymentFallback_timeout(Integer id){
        return "系统超时或者异常，请稍后重试，o(╥﹏╥)o";
    }




}
