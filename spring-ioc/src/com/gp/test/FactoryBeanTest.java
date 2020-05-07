package com.gp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gp
 * @create 2020/1/29 19:50
 */
public class FactoryBeanTest {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");

    @Test
    public void testFactoryBean(){
        System.out.println(ioc.getBean("carFactoryImpl"));

    }
}
