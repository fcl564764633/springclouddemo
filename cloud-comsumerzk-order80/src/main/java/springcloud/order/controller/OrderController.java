package springcloud.order.controller;

import com.fcl.springcloud.entitys.CommonResult;
import com.fcl.springcloud.entitys.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springcloud.order.service.OrderService;

/**
 * @Author: FCL
 * @DateTime: 2020/5/11 15:30
 * @Description: TODO
 */
@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/getName")
    public CommonResult<Payment> getName(@RequestParam("id") Integer id){
        System.out.println("进来order消费端");
        //return new CommonResult(400,"寄来了",null);
        return orderService.getName(id);
    }
}
