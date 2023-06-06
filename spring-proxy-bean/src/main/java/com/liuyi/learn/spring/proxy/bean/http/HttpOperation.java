package com.liuyi.learn.spring.proxy.bean.http;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.http.HttpClient;

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
    String method() default "GET";
    HttpClient.Version version() default HttpClient.Version.HTTP_1_1;
    String contentType() default "application/json";
    long timeoutSeconds() default 3L;
}
