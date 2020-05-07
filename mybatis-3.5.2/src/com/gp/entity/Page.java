package com.gp.entity;

import java.util.List;

/**
 * @author gp
 * @create 2020/2/2 16:38
 */
public class Page {
    private int start;
    private int end;
    private int count;
    private List<Account> accounts;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
