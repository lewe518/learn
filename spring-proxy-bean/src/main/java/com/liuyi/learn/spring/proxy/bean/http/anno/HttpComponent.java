package com.liuyi.learn.spring.proxy.bean.http.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * HttpComponent
 *
 * @author xc_liuyi
 * Create at: 2023/6/6
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HttpComponent {
}
