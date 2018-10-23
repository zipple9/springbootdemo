package com.wzy.demo.Controller;



//import com.wzy.demo.Dao.Dao;
import com.wzy.demo.Dao.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/rest")
public class HomeController {
    @Autowired
    private userMapper um;




    @RequestMapping("/{username}")
    public String query(@PathVariable("username") String username){
        return um.getPassword(username);
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

    @RequestMapping("/test")
    public String test(){
        return um.getPassword("zhang3");
//        return dao.getPassword("zhang3");
    }






}