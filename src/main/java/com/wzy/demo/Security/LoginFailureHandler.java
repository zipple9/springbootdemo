package com.wzy.demo.Security;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * Created by wzy on 2018/10/23 20:12
 **/

@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    public LoginFailureHandler(){
        this.setDefaultFailureUrl("/error/loginerror.html");
    }
}
