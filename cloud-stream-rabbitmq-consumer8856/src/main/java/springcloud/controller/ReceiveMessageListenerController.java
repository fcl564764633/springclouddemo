package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author: FCL
 * @DateTime: 2020/5/18 14:41
 * @Description: TODO
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void intput(Message<String> message){
        System.out.println("消费者2号 端口号："+serverPort+"，----接收到的消息："+message.getPayload());
    }
}