package com.liuyi.learn.spring.circular.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * AService
 *
 * @author Eason Liu
 * Create at: 2023/8/1
 */
@Component
public class AService {
    @Autowired
    private BService bService;
}
