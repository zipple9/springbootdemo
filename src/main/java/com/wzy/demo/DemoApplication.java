package com.wzy.demo;

import com.wzy.demo.Security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //这个注解自带 @EnableAutoConfiguration @ComponentScan
public class DemoApplication {

    public static void main(String[] args) {
        System.out.print("start running");
        SpringApplication.run(DemoApplication.class, args);
    }
}
