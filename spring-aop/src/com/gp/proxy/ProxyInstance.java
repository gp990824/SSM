package com.gp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Gp
 * @create 2020/4/22 18:38
 */
//产生代理对象
public class ProxyInstance implements InvocationHandler {

    //代理对象必须包含目标对象
    Object proxy;

    public ProxyInstance(Object proxy) {
        this.proxy = proxy;
    }

    public Object getInstance() {
        return Proxy.newProxyInstance(proxy.getClass().getClassLoader(), proxy.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.proxy, args);
    }
}
