package com.gp.test;

import com.gp.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Gp
 * @create 2020/3/11 19:35
 */
public class PersonTest {
    @Test
    public void testXML(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        Person person = (Person) ioc.getBean("person");
        System.out.println(person);
    }
}
