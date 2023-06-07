package com.liuyi.learn.spring.proxy.bean.http.proxy;

import java.lang.reflect.Proxy;

/**
 * HttpOperationFactory
 *
 * @author xc_liuyi
 * Create at: 2023/6/6
 */
@SuppressWarnings("all")
public class HttpOperationFactory {
    public static <T> T getInstance(Class<T> interfaceClass) {
        HttpInvocationHandler handler = new HttpInvocationHandler();
        T instance = (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[] {interfaceClass}, handler);
        return instance;
    }
}
