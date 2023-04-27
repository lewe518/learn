package com.liuyi.learn.log.logback;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LogbackDemo
 *
 * @author xc_liuyi
 * Create at: 2023/4/24
 */
public class LogbackDemo {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogbackDemo.class);
        logger.trace("======trace");
        logger.debug("======debug");
        logger.info("======info");
        logger.warn("======warn");
        logger.error("======error");

        ILoggerFactory loggerFactory = LoggerFactory.getILoggerFactory();
        System.out.println(loggerFactory);
    }
}
