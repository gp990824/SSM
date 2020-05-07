package com.gp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gp
 * @create 2020/1/29 17:28
 */
public class ObjectTest {
    private ApplicationContext ioc  = new ClassPathXmlApplicationContext("ioc2.xml");

    @Test
    public void testObject(){
        Object person1 = ioc.getBean("person2");
        Object person2 = ioc.getBean("person2");
        System.out.println(person1 == person2);

    }
}
