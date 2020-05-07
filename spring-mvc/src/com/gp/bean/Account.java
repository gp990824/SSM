package com.gp.bean;

/**
 * @author gp
 * @create 2020/2/3 20:43
 */
public class Account {
    private String name;

    private Integer cardid;
    private Integer balance;

    public Account(){

    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", cardid=" + cardid +
                ", balacne=" + balance +
                '}';
    }

    public Account(String name, Integer cardid, Integer balance) {
        this.name = name;
        this.cardid = cardid;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
