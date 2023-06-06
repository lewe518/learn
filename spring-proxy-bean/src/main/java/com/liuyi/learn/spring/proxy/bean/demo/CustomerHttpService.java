package com.liuyi.learn.spring.proxy.bean.demo;

import com.liuyi.learn.spring.proxy.bean.framework.HttpOperation;

/**
 * BaiduHttpService
 *
 * @author xc_liuyi
 * Create at: 2023/6/5
 */
public interface CustomerHttpService {
    @HttpOperation(url = "https://api-101.glitch.me/customers", method = "post")
    String getAllCustoms();
}
