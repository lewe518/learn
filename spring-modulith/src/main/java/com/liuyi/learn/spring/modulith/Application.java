package com.liuyi.learn.spring.modulith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.core.ApplicationModules;

/**
 * Application
 *
 * @author Eason Liu
 * Create at: 2023/7/20
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(new Class[] {Application.class}, args);
        var modules = ApplicationModules.of(Application.class);
    }
}
