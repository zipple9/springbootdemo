package com.wzy.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Created by wzy on 2018/10/19 18:16
 **/
@Configuration
@EnableWebSecurity     //这个是springsecurity的注解
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home","index").permitAll()  //可以直接访问
//                .antMatchers("/hello").hasRole("USER")
//                .anyRequest().authenticated()  //登陆后即可访问
                .antMatchers("/hello").authenticated()
                .and()
            .formLogin()
                .loginPage("/login").permitAll()
                .and()
            .csrf()
                .disable() // 关闭csrf
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//            .logout()
//                .permitAll();

    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("111111")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}