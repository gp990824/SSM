package com.gp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gp
 * @create 2020/1/31 18:22
 */
@Repository
public class Acount {
    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Transactional(propagation = Propagation.REQUIRED)//不开启新的事务
    public int update(String name, int money) {
        String sql = "update account set balance=balance+? where name=?";
//        int i = 1 / 0;
//        System.out.println("hhhhh");
        return jdbcTemplate.update(sql, money, name);
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)//开启新的事务(不会影响主事务的运行)
    public Integer query(String name) {
        String sql = "select BALANCE from account where NAME=?";
//        int i = 1 / 0;
        return jdbcTemplate.queryForObject(sql, Integer.class, name);
    }
}
