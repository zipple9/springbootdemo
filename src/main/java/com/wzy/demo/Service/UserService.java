package com.wzy.demo.Service;

import com.wzy.demo.Dao.MyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by wzy on 2018/10/31 13:43
 **/
@Component
public class UserService extends rootService{

    @Autowired
    public MyDao md;


    public void updatePassword(String password,String username){
        logger.info(password);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        password=encoder.encode(password);
        md.updatePassword(password,username);
        logger.info(password);



    }

}
