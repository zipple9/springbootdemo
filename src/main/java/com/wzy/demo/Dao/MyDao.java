package com.wzy.demo.Dao;

import com.wzy.demo.Model.Role;
import com.wzy.demo.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by wzy on 2018/10/30 11:44
 **/
@Mapper
@Service
public interface MyDao {


    Set<Role> getRolesByUsername(@Param("username") String username);

    User getUserByUsername(@Param("username") String username);

    String getPassword(@Param("username") String username);
}
