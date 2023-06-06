package com.liuyi.learn.spring.proxy.bean.http.anno;

import com.liuyi.learn.spring.proxy.bean.spring.RepositoryScannerRegistrar;
import org.springframework.context.annotation.Import;

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
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(RepositoryScannerRegistrar.class)
public @interface HttpComponent {
}
