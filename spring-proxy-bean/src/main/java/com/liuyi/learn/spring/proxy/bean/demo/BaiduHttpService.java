package com.liuyi.learn.spring.proxy.bean.demo;

import com.liuyi.learn.spring.proxy.bean.http.anno.HttpComponent;
import com.liuyi.learn.spring.proxy.bean.http.anno.HttpOperation;

/**
 * BaiduHttpService
 *
 * @author xc_liuyi
 * Create at: 2023/6/5
 */
@HttpComponent
public interface BaiduHttpService {
    @HttpOperation(url = "https://www.baidu.com")
    String getBaiduHomePage();
}
