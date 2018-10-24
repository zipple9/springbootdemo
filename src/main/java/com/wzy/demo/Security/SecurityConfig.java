package com.wzy.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Created by wzy on 2018/10/19 18:16
 **/
@Configuration
@EnableWebSecurity     //这个是springsecurity的注解
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
//                .antMatchers("/hello").hasRole("USER")
//                .anyRequest().authenticated()  //登陆后即可访问
                .antMatchers("/hello").authenticated()
                .anyRequest().permitAll()  //可以直接访问
                .and()
            .formLogin()
                .loginPage("/loginPage").successHandler(loginSuccessHandler).failureHandler(loginFailureHandler)
                .and()
            .logout().logoutUrl("/home")
                .and()
            .csrf()
                .disable() // 关闭csrf
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//            .logout()
//                .permitAll();

    }
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user").password(new BCryptPasswordEncoder().encode("111111")).roles("USER");
    }



}