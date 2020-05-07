package com.gp.config;

import com.gp.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gp
 * @create 2020/3/11 19:43
 */

/**
 * 其中: @ComponentScan.Filter(type = FilterType.xxx
 * FilterType是一个枚举类, 共有五个枚举常量
 * FilterType.CUSTOM:
 */
@ComponentScan(value = "com.gp"/*, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
                Controller.class, Repository.class
        })
}*/)//相当于包扫描
@Configuration// 告诉Spring这是一个配置类, 不用编写xml配置文件就能往容器中注册bean同时该类也是一个组件, 也会被注册到容器中
public class MyConfigurationClass {
    /**
     * 该bean的id就是方法名, 或者在Bean注解上标注一个id
     * @return
     */
    @Bean
    public Person person(){
        Person person = new Person();
        person.setAge(23);
        person.setName("gou");
        return person;
    }
}
