package com.gp.servlet;

import com.gp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author gp
 * @create 2020/1/30 16:18
 */
public class BaseServlet<T> {

//   不需要将BaseService注册到ioc容器中 其两个子类已注册到ioc容器中,
//   当获取某个xxxservlet时,spring会自动将其泛型传入到该类的泛型中
//    通过调用xxxservlet.save()时,baseService的类型就会动态的改变
    @Autowired
    BaseService<T> baseService;

    public void save() {
        baseService.save();
    }
}
