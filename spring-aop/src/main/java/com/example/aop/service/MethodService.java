package com.example.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MethodService {
    public void method() {
        log.info(this.getClass().getName() + ".method()");
    }
}
