package com.gp.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Gp
 * @create 2020/3/27 15:33
 */
public class GetProxyInstance {
    public static JdkProxyInterface getProxy(JdkProxyInterface jdkProxy) {
        ClassLoader classLoader = jdkProxy.getClass().getClassLoader();
        Class<?>[] classes = jdkProxy.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * 重写这个方法来为JdkProxyImpl实现代理
             * @param proxy 代理对象(任何时候都不要动这个对象)
             * @param method 当前将要执行的目标对象的方法
             * @param args 通过反射执行方法, 传入放射对象的方法中
             * @return 目标方法执行完的返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //目标方法的执行
                System.out.println("before-------");
                Object invoke = method.invoke(jdkProxy, args);
                System.out.println("after--------");
                return invoke;
            }
        };
        Object proxyInstance = Proxy.newProxyInstance(classLoader, classes, invocationHandler);
        return (JdkProxyInterface) proxyInstance;
    }
}
