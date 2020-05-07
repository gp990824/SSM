package com.gp.servlet;

import com.gp.bean.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author gp
 * @create 2020/2/23 19:48
 */
@Controller
public class TestServlet {
    @Autowired
    private Test test;

    public void test(){
        System.out.println(test);
    }
}
