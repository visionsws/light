package com.vicente.light.myconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/**
 * @author shiweisen
 * @since 2018-01-30
 */
@Component
@PropertySource(value = "classpath:myconfig/mycustomer.properties",encoding = "utf-8")
@ConfigurationProperties(prefix = "my.customer")
public class MyCustomer {

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
