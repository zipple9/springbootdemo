package com.wzy.demo.Security;

import com.wzy.demo.Dao.userMapper;
import com.wzy.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wzy on 2018/10/22 15:58
 **/
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    userMapper um;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.springframework.security.core.userdetails.User us=new org.springframework.security.core.userdetails.User("user","111111",AuthorityUtils.commaSeparatedStringToAuthorityList("USER"));

        return us;
    }
}
