package com.gp.test;

import com.gp.bean.Car;
import com.gp.bean.ComplexType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author gp
 * @create 2020/1/29 14:54
 */
public class ComplexTest {
   private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
   private ComplexType bean = (ComplexType) ioc.getBean("complexType");
    //测试引用类型
    @Test
    public void testRef(){
        System.out.println(bean.getCar());
    }

    //测试List集合
    @Test
    public void testList(){
        System.out.println(bean.getCars());
    }

    //测试Map
    @Test
    public void testHashMap(){
        System.out.println(bean.getMap());
    }

    //测试数组
    @Test
    public void testArray(){
        System.out.println(Arrays.toString(bean.getHobbies()));
    }

    //测试级联属性的赋值
    @Test
    public void testCascade(){
        ComplexType complexType2 = (ComplexType) ioc.getBean("complexType2");
        Car car = (Car) ioc.getBean("car");
        System.out.println(car);
        System.out.println("--------------------------");
        System.out.println(complexType2.getCar());
        //级联属性会修改原属性的值
    }
}
