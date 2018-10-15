package com.wzy.demo.Controller;


import com.wzy.demo.Dao.userMapper;
import com.wzy.demo.Model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

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
        List<user> rolelist=um.selectByUsername(username);
        return rolelist.get(0).getName();
    }
    @RequestMapping("/listRoles/{username}")
    public Set<String> listRoles(@PathVariable("username") String username){
        Set<String> roleslist=um.listRoles(username);
        return roleslist;
    }

    @RequestMapping("/listPermissions/{username}")
    public Set<String> listPermissions(@PathVariable("username") String username){
        Set<String> permissionslist=um.listPermissions(username);
        return permissionslist;
    }


}