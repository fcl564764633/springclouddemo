package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: FCL
 * @DateTime: 2020/5/11 15:14
 * @Description: TODO
 */
@EnableDiscoveryClient
@EnableFeignClients //feign 远程调用服务
@SpringBootApplication
public class OrderZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class,args);
    }
}
