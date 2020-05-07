package com.gp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gp
 * @create 2020/1/29 19:26
 */
public class FactoryTest {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");

    //测试静态工厂,得到Plane对象
    @Test
    public void testStaticFactory(){
        Object factory = ioc.getBean("factory");
        System.out.println(factory);
    }

    //测试实例工厂
    @Test
    public void testInstanceFactory(){
        System.out.println(ioc.getBean("plane"));
    }
}


