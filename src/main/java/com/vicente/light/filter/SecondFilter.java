package com.vicente.light.filter;

/**
 * @author shiweisen
 * @since 2018-02-05
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * 会过滤到地址栏为以下参数的请求
 * 需要主类加入@ServletComponentScan
 */
public class SecondFilter implements Filter {
    private static Logger LOG= LoggerFactory.getLogger(SecondFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        String requestURI=req.getRequestURI();
        LOG.info("这个是第二个过滤器，基于注册的过滤器-->"+requestURI);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
