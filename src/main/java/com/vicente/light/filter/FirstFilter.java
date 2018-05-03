package com.vicente.light.filter;

/**
 * @author shiweisen
 * @since 2018-02-05
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * 会过滤到地址栏为以下参数的请求
 * 需要主类加入@ServletComponentScan
 */
//@WebFilter(filterName = "firstFilter",urlPatterns = {"/test/*","/hello/*"})
public class FirstFilter implements Filter {
    private static Logger LOG= LoggerFactory.getLogger(FirstFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        String requestURI=req.getRequestURI();
        LOG.info("过滤到的请求-->"+requestURI);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
