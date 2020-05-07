package com.gp.utils;


import org.aspectj.lang.JoinPoint;

/**
 * @author gp
 * @create 2020/1/30 20:55
 */
public class LogUtils {
    public void before(JoinPoint point) {
        System.out.println(point.getSignature().getName() + "方法执行前!");
    }

    public void after(JoinPoint point) {
        System.out.println(point.getSignature().getName() + "方法已结束!");
    }

    public void afterReturning(JoinPoint point, Object result) {
        String name = point.getSignature().getName();
        System.out.println(name + "方法返回结果为:" + result);
    }

    public void afterThrowing(JoinPoint point, Exception e) {
        System.out.println(point.getSignature().getName() + "方法抛出异常:" + e);
    }

}
