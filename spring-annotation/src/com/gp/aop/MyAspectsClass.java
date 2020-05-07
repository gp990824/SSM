package com.gp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author Gp
 * @create 2020/3/24 11:59
 */
@Aspect//告知Spring这是一个切面类
public class MyAspectsClass {
    @Pointcut("execution(public int com.gp.aspect.AspectedClass.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {//JoinPoint必须作为第一个参数,否则无法识别
        String name = joinPoint.getSignature().getName();//获取被切入的方法的方法名
        System.out.println("前置通知");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("后置通知");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterrReturn(Object result) {
        //告知Spring 被切入的方法返回值为result
        System.out.println("返回通知");
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(Exception e) {
        //告知Spring被切入的方法抛出的异常类型
        System.out.println("异常通知");
    }
}
