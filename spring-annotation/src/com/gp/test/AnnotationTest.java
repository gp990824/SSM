package com.gp.test;

import com.gp.config.MyConfigurationClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Gp
 * @create 2020/3/11 19:46
 */
public class AnnotationTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfigurationClass.class);
        System.out.println(ioc.getBean(MyConfigurationClass.class));
//        System.out.println(ioc.getBean("person"));
    }
}
