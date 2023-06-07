package com.liuyi.learn.spring.proxy.bean;

import com.liuyi.learn.spring.proxy.bean.demo.BaiduHttpService;
import com.liuyi.learn.spring.proxy.bean.http.anno.HttpComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * SpringApplication
 *
 * @author xc_liuyi
 * Create at: 2023/6/6
 */
@HttpComponentScan(basePackages = "com.liuyi.learn.spring.proxy.bean.demo")
@SpringBootApplication
public class ProxyBeanSpringApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ProxyBeanSpringApplication.class, args);
        BaiduHttpService baiduHttpService = ctx.getBean(BaiduHttpService.class);
        System.err.println(baiduHttpService.getBaiduHomePage());
    }
}
