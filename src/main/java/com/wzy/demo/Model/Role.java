package com.wzy.demo.Model;

/**
 * Created by wzy on 2018/10/15 14:14
 **/
public class Role {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(){}
    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
