package com.gp.test;

import com.gp.servlet.StudentServlet;
import com.gp.servlet.TestServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gp
 * @create 2020/1/30 12:47
 */
public class AutoWiredTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("autoWired.xml");

    @Test
    public void testAutoWired(){
       StudentServlet servlet = (StudentServlet) ioc.getBean("servlet");
       servlet.doGet();
    }

    @Test
    public void test2(){
        StudentServlet bean = ioc.getBean(StudentServlet.class);
        System.out.println(bean);
        System.out.println(bean.getStudent());
    }

    //如果创建的bean不是单例的,同样可以自动装配成功
    @Test
    public void test3(){
        TestServlet bean = ioc.getBean(TestServlet.class);
        bean.test();
    }
}
