package com.gp.bean;

/**
 * @author gp
 * @create 2020/1/29 14:46
 */
public class Car {
    private String carName;
    private Integer price;
    private String color;

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    public Car() {
        System.out.println("Car对象被创建!");
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
