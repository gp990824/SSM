package com.gp.entity;

/**
 * @author gp
 * @create 2020/2/2 20:40
 */
public enum Car {
    AUDI(450000,"奥迪A6"),BENZ(1000000,"奔驰S级"),BMW(320000,"宝马三系"),
    FERRARI(45000000,"法拉利F8"),PORSCHE(1500000,"保时捷Panamera");
    private Integer price;
    private String name;
    private Car(Integer price,String name){
        this.price = price;
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public static Car getCar(String name){
        switch (name){
            case "法拉利F8":
                return FERRARI;
            case "奔驰S级":
                return BENZ;
            case "奥迪A6":
                return AUDI;
            case "宝马三系":
                return BMW;
            default:
                return PORSCHE;
        }
    }
}
