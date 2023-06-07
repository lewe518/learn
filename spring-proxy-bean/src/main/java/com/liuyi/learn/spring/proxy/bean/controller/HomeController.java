package com.liuyi.learn.spring.proxy.bean.controller;

import com.liuyi.learn.spring.proxy.bean.demo.BaiduHttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController
 *
 * @author xc_liuyi
 * Create at: 2023/6/6
 */
@RestController
public class HomeController {
    /*@Autowired
    private BaiduHttpService baiduHttpService;

    @RequestMapping("/")
    public String index() {
        return baiduHttpService.getBaiduHomePage();
    }*/
}
