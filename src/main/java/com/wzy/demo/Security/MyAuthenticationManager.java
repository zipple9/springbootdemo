package com.wzy.demo.Security;

import com.wzy.demo.Dao.userMapper;
import com.wzy.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 *
 * 这个类是用来验证 spring security 拦截 并封装好的Authentication
 * Created by wzy on 2018/10/25 16:30
 **/
@Component
public class MyAuthenticationManager implements AuthenticationManager {

    @Autowired
    userMapper um;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {

        User userdetails=um.getUserByUsername(auth.getName());

        if(userdetails !=null){
            if(auth.getCredentials()==userdetails.getPassword()){
                System.out.println("login successful");

                return new UsernamePasswordAuthenticationToken(auth.getName(),auth.getCredentials())
            }
        }
        if(auth.getCredentials()=)
        return null;
    }
}

