package com.wzy.demo.Config;


import com.wzy.demo.Dao.userMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration

public class Config {
//    @Bean
//    @ConfigurationProperties(prefix = "app.datasource")
//    public DataSource dataSource(){
//        return DataSource;
//    }
}
