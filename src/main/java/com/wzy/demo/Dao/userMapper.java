package com.wzy.demo.Dao;

import com.wzy.demo.Model.Role;
import com.wzy.demo.Model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by wzy on 2018/10/13 23:04
 **/

@Mapper
@Service
public interface userMapper {



    @Select("select password from user where name=#{username}")
    String getPassword(@Param("username") String username);

//    @Select("select * from user where name={username}")
//    User getUserByUsername(@Param("username") String username);

     /** 下面的@Results 相当于xml中的resultMap 结果集
        @many 就是先执行many中的sql 参数是上层的name  得到的结果指定到字段roles中，即 将返回的Role对象指定到user对象的roles字段
        user对象的roles字段是一个Set<Role>  返回的一个Role对象 自动就被包装成了set
     */
    @Select("select * from user where user.name=#{username}")
    @Results({
            @Result(property = "name",column = "name"),
            @Result(property = "password",column = "password"),
            @Result(property = "roles",column = "name",
                    many =@Many(select = "com.wzy.demo.Dao.userMapper.getRolesByUsername") )})
    User getUserByUsername(@Param("username") String username);


    @Select("select role.* from user " +
            "left join role on user.id=role.id " +
            "left join user_role on role.id=user_role.rid " +
            "where user.name=#{username}")
    Set<Role> getRolesByUsername(@Param("username") String username); //根据用户名查询用户的角色 一个用户目前只有一个角色


    @Select("select role.name from user " +
            "left join role on user.id=role.id " +//id后面这个空格坑死人了 没有空格拼接的sql必然报错
            "left join user_role on role.id=user_role.rid " +
            "where user.name=#{username}")
    Set<String> listRoles(@Param("username") String username);

    @Select("select permission.name from user " +
            "left join Role on user.id=role.id " +
            "left join user_role on role.id=user_role.rid " +
            "left join role_permission on user_role.rid=role_permission.rid " +
            "left join permission on role_permission.pid=permission.id")
    Set<String> listPermissions(@Param("username") String username);


    @Insert("insert into User values(id=#{id},name=#{name},password=#{password},salt=#{salt}")
    void createUser(@Param("id") int id,@Param("name") String name,@Param("password") String password,@Param("salt") String salt);








}
