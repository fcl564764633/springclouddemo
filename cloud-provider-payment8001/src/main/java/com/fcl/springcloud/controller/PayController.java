package com.fcl.springcloud.controller;

import com.fcl.springcloud.entitys.CommonResult;
import com.fcl.springcloud.entitys.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: FCL
 * @DateTime: 2020/5/11 15:41
 * @Description: TODO
 */
@RestController
@Slf4j
public class PayController {

    @RequestMapping("/payment/getName/{id}")
    public CommonResult<Payment> getName(@PathVariable("id") Integer id){
        //故意睡3秒 测试客户端 openfeign中ribbon 超时时间多少 默认1秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("进入8001服务层成功+id:"+id);
        return new CommonResult<Payment>(200,"进入8001payment",null);
    }
}
