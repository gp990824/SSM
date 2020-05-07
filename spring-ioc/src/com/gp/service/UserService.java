package com.gp.service;

import com.gp.bean.User;
import org.springframework.stereotype.Service;

/**
 * @author gp
 * @create 2020/1/30 16:14
 */
@Service
public class UserService extends BaseService<User> {

    @Override
    public void save() {
        System.out.println("UserService被调用!");
    }
}
