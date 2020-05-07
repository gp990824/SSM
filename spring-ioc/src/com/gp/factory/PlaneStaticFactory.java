package com.gp.factory;

import com.gp.bean.Plane;

/**
 * @author gp
 * @create 2020/1/29 19:10
 */
//静态工厂
public class PlaneStaticFactory {
    public static Plane getPlane(String otherName){
        Plane plane = new Plane();
        plane.setCompanyName("中国航空");
        plane.setOtherName(otherName);
        plane.setPrice(9999);
        plane.setPersonNumber(256);
        return plane;
    }
}
