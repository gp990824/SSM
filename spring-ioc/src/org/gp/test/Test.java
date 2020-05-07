package org.gp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gp
 * @create 2020/3/1 16:24
 */
public class Test {
    @org.junit.Test
    public void test(){
        ApplicationContext parent = null;
        ClassPathXmlApplicationContext ioc =  new ClassPathXmlApplicationContext(parent);
        ioc.setAllowCircularReferences(false);//关闭循环依赖
        ioc.setConfigLocation("circledependency.xml");
        ioc.refresh();
//        System.out.println(ioc.getBean("helloService"));
    }
}
