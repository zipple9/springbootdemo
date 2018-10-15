package com.wzy.demo.service;

import java.io.Serializable;

public class user implements Serializable {
    private static final long serialVersionUID=1000L;
    private String id;
    private String name;
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
