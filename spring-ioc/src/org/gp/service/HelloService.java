package org.gp.service;

import org.gp.controller.HelloController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gp
 * @create 2020/3/1 16:22
 */
@Service
public class HelloService {
    @Autowired
    HelloController helloController;
    public HelloService(){
        System.out.println("初始化HelloService!");
    }
}
