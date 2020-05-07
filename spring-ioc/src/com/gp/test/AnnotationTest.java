package com.gp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gp
 * @create 2020/1/30 12:03
 */
public class AnnotationTest {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void  testannotation(){
        System.out.println(ioc.getBean("servlet"));
    }
}
