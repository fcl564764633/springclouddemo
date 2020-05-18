# springclouddemo
springcloud demo 

1.eureka 集群架构 简单例子  openfeign远程调用

2.改zk为注册中心 架构 简单例子   zk未设置集群   feign远程调用

3.增加Hystrix 断路器 （降级，熔断）例子  Hystrix dashboard 监控

4.增加网关 gateway (路由，断言，过滤器) 实现动态路由，自定义过滤器

5.消息总线（遇到问题，发送http://localhost:3344/actuator/bus-refresh post请求的时候，失败，把热部署依赖 去掉  就可以了？什么原因暂时不知）

6.消息驱动 springcloud（支持rabbitMQ 和 kafaka）  分组的重要（避免重复消费 和 持久化作用）
