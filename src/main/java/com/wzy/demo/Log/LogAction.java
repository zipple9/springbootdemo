package com.wzy.demo.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 日志  全局记录器
 *
 * Created by wzy on 2018/10/31 9:53
 **/
public class LogAction {
    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(LogAction.class);

//    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @param args
     */
    public static void main(String[] args) {
        logger.info("logback 成功了");
        logger.error("logback 成功了");
    }
}
