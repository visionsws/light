package com.vicente.light.controller;

import com.vicente.light.dto.Message;
import com.vicente.light.dto.Response;
import com.vicente.light.service.WebSocketService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shiweisen
 * @since 2018-02-07
 */
@Controller
public class WebSocketController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WebSocketService ws;

    @RequestMapping(value = "/ws")
    public String ws(){
        return  "wsTest";
    }

    /*@MessageMapping("/welcome")//浏览器发送请求通过@messageMapping 映射/welcome 这个地址。
    @SendTo("/topic/getResponse")//服务器端有消息时,会订阅@SendTo 中的路径的浏览器发送消息。
    public Response say(Message message) throws Exception {
        Thread.sleep(1000);
        return new Response("Welcome, " + message.getName() + "!");
    }*/



    @RequestMapping("/Welcome1")
    @ResponseBody
    public String say2()throws Exception
    {
        ws.sendMessage();
        return "is ok";
    }

    @SubscribeMapping("/subscribeTest")
    public Response sub() {
        logger.info("XXX用户订阅了我。。。");
        return new Response("感谢你订阅了我。。。");
    }


    @MessageMapping("/sendTest")
    //@SendTo("/topic/subscribeTest")
    public Response sendDemo(Message message) {
        logger.info("接收到了信息" + message.getName());
        return new Response("你发送的消息为:" + message.getName());
    }
}
