package com.liuyi.learn.spring.proxy.bean.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * AutoConfiguration
 *
 * @author xc_liuyi
 * Create at: 2023/6/7
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "com.liuyi.learn.spring.proxy.bean")
public class AutoConfiguration {
}
