package com.gp.entity;

import com.gp.impl.Demo;

/**
 * @author gp
 * @create 2020/1/31 12:29
 */
public class MyDemo implements Demo {


    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }
}
