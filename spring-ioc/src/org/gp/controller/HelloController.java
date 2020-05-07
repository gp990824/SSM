package org.gp.controller;

import org.gp.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author gp
 * @create 2020/3/1 16:21
 */
@Controller
public class HelloController {
    @Autowired
    HelloService helloService;
    public HelloController(){
        System.out.println("初始化HelloController!");
    }
}
