package com.gp.utils;

import org.aspectj.lang.ProceedingJoinPoint;


/**
 * @author gp
 * @create 2020/1/31 13:48
 */
//环绕通知
public class AroundLogUtils {
    public Object around(ProceedingJoinPoint point){
        Object[] params =  point.getArgs();
        Object proceed = null;
        try {
            System.out.println("环绕前置通知!");
            //利用反射调用目标方法,就是method.invoke(object,params)
            proceed = point.proceed(params);
            System.out.println("环绕返回通知!");
        } catch (Throwable throwable) {
            System.out.println("环绕异常通知!");
            throwable.printStackTrace();
        }finally {
            System.out.println("环绕后置通知!");
        }
        return proceed;
    }
}
