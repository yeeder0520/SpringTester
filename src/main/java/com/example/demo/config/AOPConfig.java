package com.example.demo.config;

import com.example.demo.h2test.entity.Member;
import com.example.demo.h2test.repo.MemberRepo;
import com.example.demo.h2test.service.MemberService;
import com.example.demo.myannotation.MyAnnotation;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Spring 容器管理的類別
 *
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/25 上午 10:01
 **/
@Component
@Aspect
@RequiredArgsConstructor
public class AOPConfig {


    private final MemberService memberService;

//    @Pointcut("execution(public * com.example.demo.controller.*.*(..))")
    @Pointcut("@annotation(com.example.demo.myannotation.MyAnnotation)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("近來切麵了Around");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MyAnnotation accountOperation = method.getAnnotation(MyAnnotation.class);
        System.out.println("Account operation annotation: " + accountOperation);
        System.out.println("Account operation value: " + accountOperation.needWrite());
        System.out.println("accountOperation.describe() = " + accountOperation.describe());

        Member member = new Member();
        member.setName(accountOperation.describe());

        memberService.saveOrUpdate(member);
        memberService.find();


    }
}
