package com.vicente.light.aspect;

import com.google.common.collect.Maps;

import com.alibaba.fastjson.JSON;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shiweisen
 * @since 2018-01-31
 */
@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.vicente.light.controller.*.*(..))")
    public void log(){}

    @Before("log()")
    public void logBefore(JoinPoint joinPoint){
        //logger.info("before method log done"+ AopContext.currentProxy().getClass());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //URL
     /*   logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class={} and method name = {}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        //参数
        logger.info("参数={}",JSON.toJSONString(joinPoint.getArgs()));*/
    }

    //可以通过JoinPoint取到aop的类名，方法参数，方法签名
    @After("log()")
    public void logAfter(JoinPoint joinPoint){
        logger.info("after method log done "+joinPoint.getTarget().getClass()+",args="+ Arrays.asList(joinPoint.getArgs())+",method="+joinPoint.getSignature());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url = {} end of execution", request.getRequestURL());
    }

    /**
     * 获取返回内容
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturn(Object object){
        logger.info("response={}",object.toString());
    }
}

