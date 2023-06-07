package com.liuyi.learn.spring.proxy.bean.spring;

import com.liuyi.learn.spring.proxy.bean.http.anno.HttpComponent;
import com.liuyi.learn.spring.proxy.bean.http.proxy.HttpOperationFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 * HttpOperationBeanPostProcessor
 *
 * @author xc_liuyi
 * Create at: 2023/6/7
 */
@Component
public class HttpComponentBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        HttpComponent httpComponentAnnotation = AnnotationUtils.findAnnotation(beanClass, HttpComponent.class);

        if (beanClass.toString().contains("liuyi")) {
            System.err.println(beanClass);
        }
        if (httpComponentAnnotation != null) {
            return HttpOperationFactory.getInstance(beanClass);
        }
        return bean;
    }
}
