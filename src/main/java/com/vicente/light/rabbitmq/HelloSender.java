package com.vicente.light.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.vicente.light.dto.UserDto;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shiweisen
 * @since 2018-02-09
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void send() {
        String context = "hi, i am message all";
        System.out.println("Sender : " + context );
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", context);
    }

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }
}
