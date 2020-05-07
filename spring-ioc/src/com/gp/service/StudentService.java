package com.gp.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author gp
 * @create 2020/1/30 12:01
 */
@Service
//@Scope(value = "prototype")
public class StudentService {
    public void service(){
        System.out.println("逻辑层正在被调用!");
    }
}


