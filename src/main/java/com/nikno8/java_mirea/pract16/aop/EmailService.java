package com.nikno8.java_mirea.pract16.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
@Async
public class EmailService {
    @After("execution(* set*())")
    public void afterSaveAnyObject(JoinPoint joinPoint){
        log.info("Method {}: object save", joinPoint.getSignature());
    }
}
