package com.vicente.light;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = {"com.vicente.light.mapper"})
public class LightApplication {

	public static void main(String[] args) {
		SpringApplication.run(LightApplication.class, args);
	}

}
