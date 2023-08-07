package com.liuyi.learn.spring.circular.impl;

import org.springframework.stereotype.Component;

/**
 * AService
 *
 * @author Eason Liu
 * Create at: 2023/8/1
 */
@Component
public class AService {
    private BService bService;
    public AService(BService bService) {
        this.bService = bService;
    }
}
