package com.liuyi.learn.spring.proxy.bean.http;

import com.liuyi.learn.spring.proxy.bean.http.anno.HttpOperation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * HttpInvocationHandler
 *
 * @author xc_liuyi
 * Create at: 2023/6/5
 */
public class HttpInvocationHandler implements InvocationHandler {
    public HttpInvocationHandler() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HttpOperation anno = method.getAnnotation(HttpOperation.class);

        HttpRequest.Builder builder = getHttpRequest(anno, args);

        HttpRequest request = builder
                .version(anno.version())
                .headers("Content-type", anno.contentType())
                .timeout(Duration.ofSeconds(anno.timeoutSeconds()))
                .uri(URI.create(anno.url()))
                .build();

        HttpResponse<String> response =
                HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    private HttpRequest.Builder getHttpRequest(HttpOperation httpOperation, Object[] args) {
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        if ("get".equalsIgnoreCase(httpOperation.method())) {
            builder = builder.GET();
        }
        if ("post".equalsIgnoreCase(httpOperation.method())) {
            HttpRequest.BodyPublisher requestBody = HttpRequest.BodyPublishers.ofString(args[0].toString());
            builder = builder.POST(requestBody);
        }
        return builder;
    }
}
