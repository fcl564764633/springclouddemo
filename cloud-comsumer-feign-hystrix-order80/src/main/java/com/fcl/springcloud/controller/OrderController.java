package com.fcl.springcloud.controller;

import com.fcl.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: FCL
 * @DateTime: 2020/5/13 14:21
 * @Description: TODO
 */
@RestController
//全局方法对应的 兜底方法
//@DefaultProperties(defaultFallback = "orderError_global_Fallback")
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/hystrix/ok/{id}")
    //不加@HystrixCommand 注解 就没有断路器功能
    public String paymentInfo_ok(@PathVariable("id")Integer id){
        return orderService.paymentInfo_ok(id);
    }

    @GetMapping("/order/hystrix/timeout/{id}")
//    @HystrixCommand //有全局 Fallback方法  如果你想让这个方法需要断路功能 要加这个参数
    public String paymentInfo_timeout(@PathVariable("id")Integer id){
        return orderService.paymentInfo_timeout(id);
    }


    @GetMapping("/order/hystrix/timeout2/{id}")
    //具体方法对应的 兜底方法  优先级是方法上配置的  如：orderFallback_timeout
//    @HystrixCommand(fallbackMethod = "orderFallback_timeout",commandProperties ={
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String paymentInfo_timeout2(@PathVariable("id") Integer id){
        System.out.println("消费端进来超时方法");
        int number = 5;
        try {
            // int age = 10/0; 一样报错
            TimeUnit.SECONDS.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池 ："+Thread.currentThread().getName() + "paymentInfo_timeout "+ id + "超时（秒）"+ number;
    }


//下面代码具有膨胀  缺点
    //兜底方法   运行异常，超时，都会让服务降级  降级后执行的方法
    public String orderFallback_timeout(Integer id){
        return "消费端80 系统超时或者异常，请稍后重试，o(╥﹏╥)o";
    }

    //下面 一个 全局的 兜底方法   参数可以不写
    public String orderError_global_Fallback(){
        return "全局 系统超时或者异常，请稍后重试，o(╥﹏╥)o";
    }

}
