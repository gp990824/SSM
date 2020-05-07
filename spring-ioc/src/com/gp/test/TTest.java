package com.gp.test;

import com.gp.servlet.BookServlet;
import com.gp.servlet.UserServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gp
 * @create 2020/1/30 16:24
 */
//泛型的依赖注入的测试
public class TTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("autoWired.xml");

    @Test
    public void test(){
        BookServlet bookServlet = ioc.getBean(BookServlet.class);
        UserServlet userServlet = ioc.getBean(UserServlet.class);

        bookServlet.save();
        userServlet.save();

        System.out.println(bookServlet.getClass().getGenericSuperclass());
    }
}
