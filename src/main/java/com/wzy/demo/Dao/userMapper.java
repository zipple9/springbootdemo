package com.wzy.demo.Dao;

import com.wzy.demo.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by wzy on 2018/10/13 23:04
 **/

@Mapper
@Service
public interface userMapper {

    @Select("select password from User where name=#{username}")
    String getPassword(@Param("username") String username);

    @Select("select * from user where name={username}")
    User getUserByUsername(@Param("username") String username);

    @Select("select role.name from User " +
            "left join role on User.id=role.id " +//id后面这个空格坑死人了 没有空格拼接的sql必然报错
            "left join user_role on role.id=user_role.rid " +
            "where User.name=#{username}")
    Set<String> listRoles(@Param("username") String username);

    @Select("select permission.name from User " +
            "left join role on User.id=role.id " +
            "left join user_role on role.id=user_role.rid " +
            "left join role_permission on user_role.rid=role_permission.rid " +
            "left join permission on role_permission.pid=permission.id")
    Set<String> listPermissions(@Param("username") String username);


    @Insert("insert into User values(id=#{id},name=#{name},password=#{password},salt=#{salt}")
    void createUser(@Param("id") int id,@Param("name") String name,@Param("password") String password,@Param("salt") String salt);








}
