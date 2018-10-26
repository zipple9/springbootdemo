package com.wzy.demo.Security;

import com.wzy.demo.Dao.userMapper;
import com.wzy.demo.Model.Role;
import com.wzy.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by wzy on 2018/10/22 15:58
 **/
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    userMapper um;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("run MyUserDetailsService  method-loadUserByUsername");
        User us = um.getUserByUsername(username);
        if (us == null) {
            System.out.println("no username");
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for (Role role : us.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
//            System.out.println(role.getName());
        }
        return new org.springframework.security.core.userdetails.User(us.getName(),us.getPassword(), authorities);
    }
}

