package com.cx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: ChenXi
 * @time: 2021/1/18 11:19
 */
@RestController
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void Input(Message<String> message){
        System.out.println("消费者1号，----->接收到的消息： "+message.getPayload()+"\t   port: "+serverPort);
    }
}
