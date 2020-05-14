package com.fcl.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    //==========================服务熔断

    //在窗口期5秒钟中，必须超过10个请求数量（注；如果窗口期中请求数量不足10次，也不会打开断路器），
    // 如果失败达到60%以上，跳闸===开启断路器-----就调用fallback降级方法
    @HystrixCommand(fallbackMethod = "paymentcircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求数量
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")//请求失败达到60%后 跳闸
    })
    public String paymentcircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("***********id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() +"\t" + "调用成功 流水号："+serialNumber;
    }

    public String paymentcircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍后再试，┭┮﹏┭┮ id："+id;
    }
}
