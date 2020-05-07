package com.gp.test;

import com.gp.service.AcountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

/**
 * @author gp
 * @create 2020/1/31 18:33
 */
public class JdbcTemplateTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test() throws FileNotFoundException {
        AcountService bean = ioc.getBean(AcountService.class);
//        System.out.println(bean.query(2500));
        System.out.println(bean.check("gp", 10));
//        System.out.println(bean.getClass());
    }
}
