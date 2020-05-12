package springcloud.order.service;

import com.fcl.springcloud.entitys.CommonResult;
import com.fcl.springcloud.entitys.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: FCL
 * @DateTime: 2020/5/12 8:56
 * @Description: TODO
 */
@FeignClient(value = "cloud-provider-payment")
public interface OrderService {

    @GetMapping("/payment/getName/{id}")
    CommonResult<Payment> getName(@PathVariable("id") Integer id);
}
