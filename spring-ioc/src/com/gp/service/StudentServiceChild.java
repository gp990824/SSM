package com.gp.service;

import org.springframework.stereotype.Service;

/**
 * @author gp
 * @create 2020/1/30 13:30
 */
@Service
public class StudentServiceChild extends StudentService {
    @Override
    public void service(){
        System.out.println("被重写的逻辑层方法!");
    }
}
