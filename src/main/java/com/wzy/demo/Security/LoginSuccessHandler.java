package com.wzy.demo.Security;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Created by wzy on 2018/10/23 21:12
 **/
@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    public LoginSuccessHandler(){
        this.setDefaultTargetUrl("/hello");
    }
}
