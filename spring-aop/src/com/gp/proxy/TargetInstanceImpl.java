package com.gp.proxy;

/**
 * @author Gp
 * @create 2020/4/22 18:37
 */
//目标对象
public class TargetInstanceImpl implements PublicInterface {
    @Override
    public void buy() {
        System.out.println("我是日本生产商!");
    }
}
