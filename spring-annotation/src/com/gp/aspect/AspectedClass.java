package com.gp.aspect;

/**
 * @author Gp
 * @create 2020/3/24 12:00
 */
//被切面的类
public class AspectedClass {
    public int div(int i, int k) {
        System.out.println("正在执行方法");
        return i / k;
    }
}
