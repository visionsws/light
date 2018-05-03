package com.vicente.light.configura;

import com.vicente.light.filter.SecondFilter;

import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import javax.servlet.Filter;

/**
 * @author shiweisen
 * @since 2018-02-01
 */
@Configuration
public class BeanConfiguration {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BeanConfiguration.class);


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        //messageSource.addBasenames(new String[]{"classpath:messages/exception-framework"});
        messageSource.addBasenames(new String[]{"classpath:messages/exception"});
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(0);
        //logger.info(messageSource.getMessage("event.trigger.save.dto.eventType.null",null, Locale.getDefault()));
        return messageSource;
    }

    /**
     * 配置过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SecondFilter());
        registration.addUrlPatterns("/test/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("sessionFilter");
        return registration;
    }

    /**
     * 创建一个bean
     * @return
     */
    /*@Bean(name = "secondFilter")
    public Filter secondFilter() {
        return new SecondFilter();
    }*/




}
