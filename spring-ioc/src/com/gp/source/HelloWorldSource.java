package com.gp.source;

import org.junit.Test;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gp
 * @create 2020/2/29 14:02
 */
public class HelloWorldSource {
    @Test
    public void test(){
        AbstractRefreshableApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        ioc.setAllowBeanDefinitionOverriding(false);
//        AutowireCapableBeanFactory autowireCapableBeanFactory = ioc.getAutowireCapableBeanFactory();
        System.out.println(ioc.getBean("complexType"));
    }
}
