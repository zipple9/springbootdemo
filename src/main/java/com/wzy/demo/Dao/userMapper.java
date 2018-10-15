package com.wzy.demo.Dao;

import com.wzy.demo.Model.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * Created by wzy on 2018/10/13 23:04
 **/

@Mapper
public interface userMapper {
    @Select("select * from user where name=#{username}")
    List<user> selectByUsername(@Param("username") String username);

    @Select("select password from user where name=#{username}")
    String getPassword(@Param("username") String username);

    @Select("select role.name from user " +
            "left join role on user.id=role.id " +//id后面这个空格坑死人了 没有空格拼接的sql必然报错
            "left join user_role on role.id=user_role.rid " +
            "where user.name=#{username}")
    Set<String> listRoles(@Param("username") String username);

    @Select("select permission.name from user " +
            "left join role on user.id=role.id " +
            "left join user_role on role.id=user_role.rid " +
            "left join role_permission on user_role.rid=role_permission.rid " +
            "left join permission on role_permission.pid=permission.id")
    Set<String> listPermissions(@Param("username") String username);









}
