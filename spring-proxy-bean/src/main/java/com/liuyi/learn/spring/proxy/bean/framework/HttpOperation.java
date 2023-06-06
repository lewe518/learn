package com.liuyi.learn.spring.proxy.bean.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * HttpOperation
 *
 * @author xc_liuyi
 * Create at: 2023/6/5
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HttpOperation {
    String url();
    String method();
}
