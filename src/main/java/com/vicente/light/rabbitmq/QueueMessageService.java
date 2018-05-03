package com.vicente.light.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author shiweisen
 * @since 2018-02-09
 */
public interface QueueMessageService extends RabbitTemplate.ConfirmCallback {
        /**
         * 发送消息到rabbitmq消息队列
         * @param message 消息内容
         * @param exchangeEnum 交换配置枚举
         * @param queueEnum 队列配置枚举
         * @throws Exception
         */
        void send(Object message, String exchangeEnum, String queueEnum) throws Exception;

}
