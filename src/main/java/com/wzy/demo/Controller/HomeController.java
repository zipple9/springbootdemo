package com.wzy.demo.Controller;


import com.wzy.demo.Dao.userMapper;
import com.wzy.demo.service.role;
import com.wzy.demo.service.user;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private userMapper um;

    @RequestMapping(value={"/","home","index"})
    public String hello(){
        return "SpringBoot welcome";
    }

//    @RequestMapping("/{username}")
//    public String query(@PathVariable("username") String username){
//        List<user> userlist=um.selectByUsername(username);
//        return userlist.get(0).getPassword();
//    }

    @RequestMapping("/{username}")
    public String query(@PathVariable("username") String username){
        List<role> rolelist=um.queryRole(username);
        return rolelist.get(0).getName();
    }




}