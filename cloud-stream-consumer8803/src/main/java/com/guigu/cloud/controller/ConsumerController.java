package com.guigu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * sink为消息接收
 * StreamListener 进行消息监听类似于rabbitmqListen
 * */
@EnableBinding(Sink.class)
public class ConsumerController {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message){
        String receive=message.getPayload();
        System.out.println("获取mq传递值为:"+receive+" ,port:"+port);
    }
}
