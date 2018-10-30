package com.wzy.demo.Security;

import com.wzy.demo.Dao.MyDao;
import com.wzy.demo.Model.Role;
import com.wzy.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    MyDao md;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("run MyUserDetailsService  method-loadUserByUsername");
        User us = md.getUserByUsername(username);
        if (us == null) {
            System.out.println("no username");
            throw new UsernameNotFoundException("用户名不存在");
        }
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for (Role role : us.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
//            System.out.println(role.getName());
        }
        System.out.println(authorities.size());

        return new User(us.getUsername(),us.getPassword(), authorities);
    }
}

