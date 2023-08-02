package com.liuyi.learn.spring.circular.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * AService
 *
 * @author Eason Liu
 * Create at: 2023/8/1
 */
@Component
public class CService {
    @Autowired
    private AService aService;
}
