package com.liuyi.learn.spring.proxy.bean;

import com.liuyi.learn.spring.proxy.bean.demo.BaiduHttpService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringApplication
 *
 * @author xc_liuyi
 * Create at: 2023/6/6
 */
@ComponentScan("com.liuyi.learn.spring.proxy.bean")
@SpringBootApplication
public class ProxyBeanSpringApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ProxyBeanSpringApplication.class, args);
        BaiduHttpService baiduHttpService = ctx.getBean(BaiduHttpService.class);
        System.out.println(baiduHttpService.getBaiduHomePage());
    }
}
