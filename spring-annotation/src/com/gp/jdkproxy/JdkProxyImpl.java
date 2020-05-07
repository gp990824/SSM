package com.gp.jdkproxy;

/**
 * @author Gp
 * @create 2020/3/27 14:56
 */
//被代理的类, 用这个代理对象来调方法, 就可在这个方法的执行前后干一些事
public class JdkProxyImpl implements JdkProxyInterface {
    @Override
    public void test() {
        System.out.println("执行目标方法");
    }
}
