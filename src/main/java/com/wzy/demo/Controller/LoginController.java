package com.wzy.demo.Controller;

import com.wzy.demo.Security.SessionManager;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/loginPage")
    public void login(HttpServletRequest request) throws Exception{
        System.out.println("/"+Thread.currentThread().getStackTrace()[1].getMethodName());

        HttpSession session=request.getSession();

        try{
            String sessionId=session.getId();
            if (session.isNew()) {
                System.out.println("session创建成功，session的id是："+sessionId);
            }
            else {
                System.out.println("服务器已经存在该session了，session的id是："+sessionId);
            }

        }catch (Exception e){
            System.out.println(e);
            System.out.println("没有拿到sessionId");
        }

//        return "loginPage";
    }



    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        System.out.println("/"+Thread.currentThread().getStackTrace()[1].getMethodName());
        request.getSession(false).invalidate();
        return "/home";
    }

}
