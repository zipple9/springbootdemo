package com.wzy.demo;

import com.wzy.demo.Security.SecurityConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //这个注解自带 @EnableAutoConfiguration @ComponentScan
//@MapperScan("com.wzy.demo.Dao.Mapper")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
