package com.vicente.light.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author shiweisen
 * @since 2018-01-24
 */
@Component
public class UserConfig {

    @Autowired
    private Environment environment;

    @Value("${local.name}")
    private String localName;

    @Value("${tomcat.port:10000}")
    private int port;

    public void show(){
        System.out.println(environment.getProperty("local.ip"));
        //重载方法，使得读取到的数据是Integer类型的
        System.out.println(environment.getProperty("tomcat.port",Integer.class,10000));
        System.out.println(localName);
        System.out.println(port);

        //在配置文件中引用引用已有的变量
        System.out.println(environment.getProperty("local.url"));
    }

}
