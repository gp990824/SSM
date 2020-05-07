package com.gp.test;

import com.gp.entity.MyDemo;
import com.gp.impl.Demo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gp
 * @create 2020/1/31 12:28
 */
public class AopTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("aop.xml");
    @Test
    public void test(){
        ioc.getBean(Demo.class).add(1,0);
    }
}
