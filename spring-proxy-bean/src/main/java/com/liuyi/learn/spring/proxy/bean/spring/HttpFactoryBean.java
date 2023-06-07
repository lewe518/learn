package com.liuyi.learn.spring.proxy.bean.spring;

import com.liuyi.learn.spring.proxy.bean.http.proxy.HttpOperationFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * HttpFactoryBean
 *
 * @author xc_liuyi
 * Create at: 2023/6/6
 */
public class HttpFactoryBean<T> implements FactoryBean<T> {
    private final Class<T> annoInterface;
    public HttpFactoryBean(Class<T> annoInterface) {
        this.annoInterface = annoInterface;
    }

    @Override
    public T getObject() throws Exception {
        return HttpOperationFactory.getInstance(annoInterface);
    }

    @Override
    public Class<?> getObjectType() {
        return annoInterface;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
