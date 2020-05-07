package com.gp.bean;

/**
 * @author gp
 * @create 2020/1/29 19:11
 */
public class Plane {
    private String companyName;
    private Integer personNumber;
    private Integer price;
    private String otherName;

    public void init(){
        System.out.println("正在初始化Plane类!");
    }
    public void destroy(){
        System.out.println("Plane类已被销毁!");
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "companyName='" + companyName + '\'' +
                ", personNumber=" + personNumber +
                ", price=" + price +
                ", otherName='" + otherName + '\'' +
                '}';
    }
}
