package com.gp.entity;

/**
 * @author gp
 * @create 2020/1/8 19:24
 */
public class Student {
    private Integer snum;
    private String sname;
    private int sage;
    private String saddress;

    public Student() {
    }

    public Student(Integer snum, String sname, int sage, String saddress) {
        this.snum = snum;
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "snum=" + snum +
                ", name='" + sname + '\'' +
                ", sage=" + sage +
                ", saddress='" + saddress + '\'' +
                '}';
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public String getName() {
        return sname;
    }

    public void setName(String name) {
        this.sname = name;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }
}
