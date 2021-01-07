package com.guigu.cloud.service.impl;

import com.guigu.cloud.service.ISendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import java.util.UUID;

/**
 * stream消息发送
 * EnableBinding注解实现binder和exchange交互
 * Source 为消息发送
 * */
@EnableBinding(Source.class)
public class SendServiceImpl implements ISendService {

    /**
     * MessageChannel是一个函数式编程接口，注入的bean有三种类型，依据名称确定具体注入哪个bean
     * */
    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String uuid=UUID.randomUUID().toString();
        System.out.println("发送消息为:"+uuid);
        //发送消息
        output.send(MessageBuilder.withPayload(uuid).build());
        return uuid;
    }
}
