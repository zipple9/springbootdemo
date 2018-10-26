package com.wzy.demo.Model;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {
    private static final long serialVersionUID=1000L;
    private String id;
    private String name;
    private String password;
    private String salt;
    private Set<Role> roles;      //用户的角色  如admin  user 等
    private Set<String> authorities;     //用户的权限 即permission 包括用户可以执行的操作 ，如addOrder等

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String username) {
        this.name = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name,String password,String id,Set<Role> roles){
        this.id=id;
        this.name=name;
        this.password=password;
        this.roles=roles;

    } // 构造函数





    public User(){

    }
}
