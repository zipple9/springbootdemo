package com.wzy.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wzy on 2018/10/19 15:23
 **/
@Controller
public class mainController {


    @RequestMapping(value = {"/", "/home", "/index"})
    public String home() {
        System.out.println("/home");
        return "home";
    }

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("/hello");

        return "hello";
    }
//    @RequestMapping("/loginPage")
//    public String loginPage(){
//        System.out.println("/"+Thread.currentThread().getStackTrace()[1].getMethodName());
//
//        return "loginPage";
//    }


//    public User getUser() { //为了session从获取用户信息,可以配置如下
//        User us = new User();
//        SecurityContext sctx = SecurityContextHolder.getContext();
//        Authentication auth = sctx.getAuthentication();
//        if (auth.getPrincipal() instanceof UserDetails) us = (User) auth.getPrincipal();
//        return us;
//    }

    @RequestMapping("/test")
    public String test() {
        System.out.println("/" + Thread.currentThread().getStackTrace()[1].getMethodName());

        return "hello";


    }
}