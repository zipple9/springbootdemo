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
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
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
    @Autowired
    private MyUserDetailsService myUserDetailsService;



//    @Bean
//    public Md5PasswordEncoder passwordEncoder() {
//        return new Md5PasswordEncoder();
//    }　　　　//设置加密方式

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
        //应对DB中密码未加密的情况
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        auth.userDetailsService(myUserDetailsService); //DB中密码为加密，此处暂时不加密

        //使用我们实现的uds
        //Spring Security5 要求密码必须加密
    }

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
            .logout().permitAll().logoutUrl("/home")
                .and()
            .csrf()
                .disable() // 关闭csrf
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//            .logout()
//                .permitAll();

    }
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("user").password(new BCryptPasswordEncoder().encode("111111")).roles("USER");
//    }



}