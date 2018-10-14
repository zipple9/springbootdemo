package com.wzy.demo.Dao;

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
    @Select("select * from user where username=#{username}")
    List<user> selectByUsername(@Param("username") String username);




}
