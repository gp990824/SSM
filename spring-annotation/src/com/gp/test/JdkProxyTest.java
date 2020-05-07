package com.gp.test;

import com.gp.jdkproxy.GetProxyInstance;
import com.gp.jdkproxy.JdkProxyImpl;
import com.gp.jdkproxy.JdkProxyInterface;
import org.junit.Test;

/**
 * @author Gp
 * @create 2020/3/27 14:55
 */
public class JdkProxyTest {
    @Test
    public void test(){
        JdkProxyInterface jdkProxy = new JdkProxyImpl();
        jdkProxy.test();
        JdkProxyInterface proxy = GetProxyInstance.getProxy(jdkProxy);
        proxy.test();
    }
}
