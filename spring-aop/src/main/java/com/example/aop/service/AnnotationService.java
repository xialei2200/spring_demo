package com.example.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AnnotationService {

    @Deprecated // 这里用这个注解来模拟,实际使用中可以替换成自定义注解
    public void method() {
        log.info(this.getClass().getName() + ".method()");
    }
}
