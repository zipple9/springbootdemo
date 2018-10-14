package com.wzy.demo;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
public class Config {
//    @Bean
//    @ConfigurationProperties(prefix = "app.datasource")
//    public DataSource dataSource(){
//        return DataSource;
//    }
}
