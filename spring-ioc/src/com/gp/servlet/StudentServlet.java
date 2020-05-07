package com.gp.servlet;

import com.gp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author gp
 * @create 2020/1/30 12:01
 */
@Controller("servlet")
public class StudentServlet {
    /*
    将变量名作为id匹配bean,当自动装配的bean一种类型不止一种时,必须使用@Qualifier("studentService")
    注解指定id获取属性的类型    (StudentService和StudentServiceChild是同一种类型)
     */
    @Qualifier("studentServiceChild")
    @Autowired(required = true)//默认为true,如果为false则找不到就装配null而不报错
    private StudentService student;

    public void doGet() {
        student.service();
    }

    public StudentService getStudent() {
        return student;
    }

//    被AutoWired注解的方法会在加载ioc容器的时被调用
    @Autowired
    public void autoMethod(StudentServlet person, @Qualifier("studentServiceChild") StudentService service) {
        //注意:参数类型必须已经在ioc容器中注册了(基本类型不会自动装配)
        System.out.println("正在调用正在装配的方法(为参数自动装配):" + person +" + " + service);
    }
}
