package com.gp.test;

import com.gp.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gp
 * @create 2020/1/30 11:03
 */
public class SpelTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    //测试spel表达式的静态方法的调用
    @Test
    public void testsple(){
      Person person  = (Person)  ioc.getBean("person3");
        System.out.println(person);
    }
}
