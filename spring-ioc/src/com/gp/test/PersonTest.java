package com.gp.test;

import com.gp.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gp
 * @create 2020/1/29 12:08
 */
public class PersonTest {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");

    /*
        如果ioc中的bean有多个,报错 ioc.getBean(Person.class)
     */
    @Test
    public void test2(){
        Person bean = ioc.getBean("person2",Person.class);
        System.out.println(bean);
    }
    @Test
    public void test() {
        //获取ioc容器,                 当前应用的xml配置文件在classpath下
        //也可以使用FileSystemXmlApplicationContext(".xml的绝对路径")md
        Person person = (Person) ioc.getBean("person");
        System.out.println(person);
    }

    @Test
    public void test3(){
        Object person3 = ioc.getBean("person3");
        System.out.println(person3);
    }

    @Test
    public void testP(){
        Object person4 = ioc.getBean("person4");
        System.out.println(person4);
    }
}
