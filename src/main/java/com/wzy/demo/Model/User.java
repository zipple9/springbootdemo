package com.wzy.demo.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class User implements Serializable, UserDetails {
    private static final long serialVersionUID=1000L;
    private String id;
    private String username;
    private String password;
    private String salt;
    private Set<Role> roles;      //用户的角色  如admin  user 等
    private Set<SimpleGrantedAuthority> authorities;     //用户的权限 即permission 包括用户可以执行的操作 ，如addOrder等

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public String getId() {
        return id;
    }
    @Override
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Role> roles){
        this.roles=roles;
    }

    public User(){}
    public User(String name,String password,Collection<SimpleGrantedAuthority> authorities){
        this.username=name;
        this.password=password;
        this.authorities= Collections.unmodifiableSet((Set)authorities);

    } // 构造函数
    public User(String id,String username,String password,Set<Role> roles){
        this.id=id;
        this.username=username;
        this.password=password;
        this.roles= roles;

    } // 构造函数



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
