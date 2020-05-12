package com.fcl.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: FCL
 * @DateTime: 2020/5/12 17:05
 * @Description: TODO 自定义访问策略
 */
@Configuration
public class MySelfRule {

    public IRule myRule(){
        //随机访问
        return new RandomRule();
    }
}
