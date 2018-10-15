package com.wzy.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by wzy on 2018/10/15 22:02
 **/

@Service
public class Dao {
    @Autowired
    private userMapper um;


    public String getPassword(String username){
        return um.getPassword(username);
    }

    public Set<String> listRoles(String username){
        return um.listRoles(username);
    }
    public Set<String> listPermissions(String username){
        return um.listPermissions(username);
    }


}
