package com.liuyi.learn.spring.proxy.bean.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * HttpInvocationHandler
 *
 * @author xc_liuyi
 * Create at: 2023/6/5
 */
public class HttpInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HttpOperation httpOperation = method.getAnnotation(HttpOperation.class);

        HttpRequest.BodyPublisher requestBody = HttpRequest.BodyPublishers.ofString(args[0].toString());

        HttpRequest request;
        if ("post".equalsIgnoreCase(httpOperation.method())) {
            request = HttpRequest.newBuilder()
                    .POST(requestBody)
                    .uri(URI.create(httpOperation.url()))
                    .build();
            HttpResponse<String> response =
                    HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        return null;
    }
}
