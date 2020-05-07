package com.gp.test;

import com.gp.bean.Plane;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gp
 * @create 2020/1/29 20:24
 */
public class LifeTest {
    private ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    //带有生命周期
    @Test
    public void testLife(){
//        System.out.println(ioc.getBean("plane"));
//        ioc.close();
    }
}
