package com.fcl.springcloud.controller;

import com.fcl.springcloud.entitys.CommonResult;
import com.fcl.springcloud.entitys.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: FCL
 * @DateTime: 2020/5/11 15:41
 * @Description: TODO
 */
@RequestMapping("/payment")
@RestController
@Slf4j
public class PayController {

    @RequestMapping("/getName/{id}")
    public CommonResult<Payment> getName(@PathVariable("id") Integer id){
        System.out.println("进入8001服务层成功+id:"+id);
        return new CommonResult<Payment>(200,"进入payment",null);
    }
}
