package com.vicente.light.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author shiweisen
 * @since 2018-01-31
 */
@Controller
public class LoginController {

    @RequestMapping("/test/login")
    public String login(Model model){
        model.addAttribute("username","vicente");
        return "login";
    }

    @RequestMapping("/helloSocket")
    public String hello(Model model){
        model.addAttribute("time", new Date());
        model.addAttribute("message", "这是测试的内容。。。");
        model.addAttribute("toUserName", "vicente");
        model.addAttribute("fromUserName", "老许");
        return "hello";
    }
}
