package com.wzy.demo;


import com.wzy.demo.Dao.Dao;
import com.wzy.demo.Dao.userMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.wzy.demo.service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by wzy on 2018/10/13 23:10
 **/



public class test {

    @Test
    public void test1(){

    }

    public static void main(String[] args){
        Set s=new HashSet();
        s.add(1);
        System.out.println(s.isEmpty());
        System.out.println(s.iterator().next());



    }
}
