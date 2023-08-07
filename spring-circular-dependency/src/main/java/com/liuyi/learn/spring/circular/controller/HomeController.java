package com.liuyi.learn.spring.circular.controller;

import com.liuyi.learn.spring.circular.impl.AService;
import com.liuyi.learn.spring.circular.impl.BService;
import com.liuyi.learn.spring.circular.impl.CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController
 *
 * @author Eason Liu
 * Create at: 2023/8/3
 */
@RestController
public class HomeController {
    @Autowired
    private AService aService;
    @Autowired
    private BService bService;
    @Autowired
    private CService cService;

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
}
