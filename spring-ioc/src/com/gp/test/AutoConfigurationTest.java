package com.gp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gp
 * @create 2020/1/29 21:45
 */
public class AutoConfigurationTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    //测试自动装配
    @Test
    public void testAutoConf(){
        System.out.println(ioc.getBean("car2"));
    }
}
