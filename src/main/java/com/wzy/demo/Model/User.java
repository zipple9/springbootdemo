package com.wzy.demo.Model;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {
    private static final long serialVersionUID=1000L;
    private String id;
    private String name;
    private String password;
    private String salt;
    private Set<role> roles;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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






    public User(){

    }
}
