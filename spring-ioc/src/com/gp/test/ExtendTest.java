package com.gp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gp
 * @create 2020/1/29 17:17
 */
public class ExtendTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");

    @Test
    public void testExtend(){
        Object person6 = ioc.getBean("person6");
        System.out.println(person6);
    }
}
