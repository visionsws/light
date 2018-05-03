package com.vicente.light.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author shiweisen
 * @since 2018-02-09
 */
@Component
@RabbitListener(queues = "topic.A")
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("HHHHHaaadFFLfjsdlkajfaklfklj : " + hello);
    }

}
