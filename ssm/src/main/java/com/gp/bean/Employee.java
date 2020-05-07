package com.gp.bean;

/**
 * @author gp
 * @create 2020/2/5 22:30
 */
public class Employee {
    private Integer id;
    private String name;
    private Integer gender;
    private String email;
    private Dept dept;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                '}';
    }

    public Employee() {
    }

    public Employee(Integer id, String name, Integer gender, String email, Dept dept) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
