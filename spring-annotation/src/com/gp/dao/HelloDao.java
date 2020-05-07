package com.gp.dao;

import org.springframework.stereotype.Repository;

/**
 * @author Gp
 * @create 2020/3/11 20:05
 */
@Repository
public class HelloDao {
    public HelloDao(){
        System.out.println("Dao以注册!");
    }
}
