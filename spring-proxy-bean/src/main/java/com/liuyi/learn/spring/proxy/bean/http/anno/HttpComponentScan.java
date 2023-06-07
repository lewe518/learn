package com.liuyi.learn.spring.proxy.bean.http.anno;

import com.liuyi.learn.spring.proxy.bean.spring.HttpComponentRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * HttpComponentScan
 *
 * @author xc_liuyi
 * Create at: 2023/6/7
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(HttpComponentRegistrar.class)
public @interface HttpComponentScan {
    String[] basePackages() default "";
    boolean includeAll() default false;
}
