package com.example.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect //org.aspectj.lang.annotation.Aspect
@Component
public class MethodAspect {

    // 基于注解的
    @Pointcut("@annotation(java.lang.Deprecated)")
    public void annotationPointCut(){}

    // 基于方法规则拦截
    @Pointcut("execution(* com.example.aop.service.MethodService.* (..))")
    public void methodPointCut(){}

    // 后置通知
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Deprecated annotation = method.getAnnotation(Deprecated.class);
        log.error("After:注解式拦截");
    }

    @Before("methodPointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        log.error("Before:方法规则拦截:方法:" + method.getName());
    }
}
