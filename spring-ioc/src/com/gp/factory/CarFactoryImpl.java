package com.gp.factory;

import com.gp.bean.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author gp
 * @create 2020/1/29 19:43
 */

public class CarFactoryImpl implements FactoryBean<Car> {

    //获取对象
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setCarName("Panamera");
        car.setColor("black");
        car.setPrice(1300000);
        return car;
    }

    //获取对象的类型
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    //是否为单例
    @Override
    public boolean isSingleton() {
        return false;
    }
}
