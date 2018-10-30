//package com.wzy.demo.Security;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.parameters.P;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by wzy on 2018/10/22 16:06
// **/
//public class MyUserDetails implements UserDetails {
//
//    private String Username;
//    private String Password;
//    private HashSet<String> Roles;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//
//
//    public MyUserDetails(String username, String password, HashSet<String> roles){
//        this.Username=Username;
//        this.Password=password;
//        this.Roles=roles;
//
//    }
//}
