package com.wzy.demo.Security;


import com.wzy.demo.Model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wzy on 2018/10/23 21:12
 **/
@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {


    public LoginSuccessHandler(){
        this.setDefaultTargetUrl("/hint/loginSuccessful.html");
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        super.onAuthenticationSuccess(request, response, authentication);
        logger.info("用户: "+((User)authentication.getPrincipal()).getUsername()+" 登陆成功\n用户角色: "+authentication.getAuthorities());
    }
}
