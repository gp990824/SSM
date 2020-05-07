package com.gp.spingtest;

import com.gp.servlet.StudentServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author gp
 * @create 2020/1/30 15:42
 */

/**
 * spring 的单元测试
 * @ContextConfiguration(locations = "classpath:autoWired.xml")指定位置的spring配置文件
 * @RunWith(SpringJUnit4ClassRunner.class) 指定用哪种驱动进行单元测试
 */
@ContextConfiguration(locations = "classpath:autoWired.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {
    ApplicationContext ioc = null;

    @Autowired
    StudentServlet servlet;

    @Test
    public void springtest(){
        System.out.println(servlet);
    }
}
