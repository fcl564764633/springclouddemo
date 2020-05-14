package com.fcl.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: FCL
 * @DateTime: 2020/5/14 15:39
 * @Description: TODO 自定义日志过滤器
 */
@Component
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("*********come in 过滤器");
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null){
            System.out.println("用户名 为空,非法用户，o(╥﹏╥)o");
            //如果非法，设置不可接受
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //返回 完成
            return exchange.getResponse().setComplete();
        }
        //正确进入其他过滤器
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;//返回的值越小，过滤器优先级越高
    }
}
