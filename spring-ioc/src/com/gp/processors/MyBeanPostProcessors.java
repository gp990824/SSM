package com.gp.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author gp
 * @create 2020/1/29 20:39
 */
public class MyBeanPostProcessors implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "将要调用初始化方法!  并且该bean为:" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "已完成初始化方法!  并且该bean为:" + bean);
        return bean;
    }
}
