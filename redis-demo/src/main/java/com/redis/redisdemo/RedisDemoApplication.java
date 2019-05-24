package com.redis.redisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.redis.redisdemo")
public class RedisDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(RedisDemoApplication.class, args);
	}

}
