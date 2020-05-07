package com.gp.bean;

import com.gp.bean.Car;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author gp
 * @create 2020/1/29 14:48
 */
//给复杂类型的属性进行赋值
public class ComplexType {
    private Car car;
    private List<Car> cars;
    private HashMap<String,Object> map;
    private String[] hobbies;

    public ComplexType() {
//        System.out.println("ComplexType对象被创建!");
    }

    @Override
    public String toString() {
        return "ComplexType{" +
                "car=" + car +
                ", cars=" + cars +
                ", map=" + map +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public HashMap<String, Object> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Object> map) {
        this.map = map;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
