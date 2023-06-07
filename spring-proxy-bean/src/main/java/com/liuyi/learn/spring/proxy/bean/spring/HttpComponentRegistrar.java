package com.liuyi.learn.spring.proxy.bean.spring;

import com.liuyi.learn.spring.proxy.bean.http.anno.HttpComponentScan;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * RepositoryScannerRegistrar
 *
 * @author xc_liuyi
 * Create at: 2023/6/6
 */
public class HttpComponentRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes attributes =
                AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(HttpComponentScan.class.getName()));
        String[] basePackages = attributes.getStringArray("basePackages");
        boolean includeAll = attributes.getBoolean("includeAll");

        HttpComponentScanner scanner = new HttpComponentScanner(registry);
        scanner.registerFilters(includeAll);
        scanner.doScan(basePackages);
    }

}
