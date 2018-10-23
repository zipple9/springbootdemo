package com.wzy.demo.Controller;

import com.wzy.demo.Security.SessionManager;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wzy on 2018/10/23 12:06
 **/
@Controller
public class LoginController {

//    @RequestMapping("/login")
//    public String login(HttpServletRequest request) {
//        System.out.println("/"+Thread.currentThread().getStackTrace()[1].getMethodName());
//
//        HttpSession session = request.getSession();
//        if (SessionManager.isAuthenticated(session)) {
//            System.out.println("已登录");
//            return "hello.html";    //返回jsp的话 就要配置视图解析
//        }
//        Exception lastException = (Exception) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//        if (lastException != null) {
//            request.setAttribute("errorMsg", "用户名或密码错误，或者账号已被停用！");
//            // request.setAttribute("errorMsg", lastException.getMessage());
//            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//        }
//        System.out.println("未登录");
//
//        return "/error/loginerror.html";
//    }

    @GetMapping("/login")
    public String loginPage(){
        System.out.println("/"+Thread.currentThread().getStackTrace()[1].getMethodName());

        return "authentication.html";
    }
    @PostMapping("/login")
    public String login(){
        System.out.println("/"+Thread.currentThread().getStackTrace()[1].getMethodName());
        return "hello.html";
    }

}
