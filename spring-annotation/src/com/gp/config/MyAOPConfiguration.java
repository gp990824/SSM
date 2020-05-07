package com.gp.config;

import com.gp.aop.MyAspectsClass;
import com.gp.aspect.AspectedClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Gp
 * @create 2020/3/24 11:43
 */
@EnableAspectJAutoProxy//开启基于注解的切面功能
@Configuration
public class MyAOPConfiguration {
    @Bean
    public MyAspectsClass myAspectsClass() {
        return new MyAspectsClass();
    }

    @Bean
    public AspectedClass aspectedClass() {
        return new AspectedClass();
    }
}
