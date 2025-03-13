package com.example.Project.aspect;

import com.example.Project.annotation.CustomLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomLogAspect {

    @After("@annotation(com.example.Project.annotation.CustomLog)")
    public void logMethodCall(JoinPoint joinPoint) {
        System.out.println("Method called: " + joinPoint.getSignature().getName());
    }
}