package com.gp.test;

import com.gp.aspect.AspectedClass;
import com.gp.config.MyAOPConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Gp
 * @create 2020/3/24 11:43
 */
public class TestAOP {
    @Test
    public  void  test(){
        AnnotationConfigApplicationContext aop = new AnnotationConfigApplicationContext(MyAOPConfiguration.class);
        System.out.println(aop.getBean(AspectedClass.class).div(2, 2));
    }
}
