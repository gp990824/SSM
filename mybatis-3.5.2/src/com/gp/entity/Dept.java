package com.gp.entity;

import java.util.List;

/**
 * @author gp
 * @create 2020/1/9 14:59
 */
public class Dept {
    private String name;
    private List<Employee> empList;

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                '}';
    }
}
