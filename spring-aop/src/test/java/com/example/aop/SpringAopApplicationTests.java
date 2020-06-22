package com.example.aop;

import com.example.aop.service.AnnotationService;
import com.example.aop.service.MethodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAopApplicationTests {

    @Autowired
    private AnnotationService annotationService;

    @Autowired
    private MethodService methodService;

    @Test
    void aopTest() {
        annotationService.method();
        methodService.method();
    }

}
