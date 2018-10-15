package com.wzy.demo.Dao;

import com.wzy.demo.service.role;
import com.wzy.demo.service.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wzy on 2018/10/13 23:04
 **/

@Mapper
public interface userMapper {
    @Select("select * from user where name=#{username}")
    List<user> selectByUsername(@Param("username") String username);
    @Select("select role.* from user " +
            "left join role on user.id=role.id " + //id后面这个空格坑死人了 没有空格拼接的sql必然报错
            "left join user_role on user.id=user_role.uid " +
            "where user.name=#{username} ")
    List<role> queryRole(@Param("username") String username);







}
