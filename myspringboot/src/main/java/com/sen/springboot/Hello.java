package com.sen.springboot;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.sen.springboot")
public class Hello {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Hello.class, args);
    }

}
