package com.gp.controller;

import com.gp.bean.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author gp
 * @create 2020/2/3 20:00
 */
@Controller
public class ParamHandler {
    /**如何获取请求参数,参数名与方法的形参名一致即可,或者在形参上加注解@RequestParameter("参数名")
     *      1.@RequestParameter有以下参数
     *             value:参数名
     *             required:是否为必须的(默认为true)
     *             defaultValue:默认值
     *      2.@PathVariable()是获取路径上的值的,而前者是获取参数的值
     *
     *      获取请求头的信息:@RequestHeader,同样具有上面三种属性
     *
     *      获取Cookie中JSESSIONID的值 @CookieValue("JSESSIONID"),同样具有上面三种属性
     * @param username
     * @return
     */
    @RequestMapping("/paramHandler")
    public String getParams(@RequestParam(value = "user",required = false) String username,
                            @RequestHeader(value = "User-Agent",required = false, defaultValue = "User-Agent") String userAgent,
                            @CookieValue(value = "JSESSIONID",required = false,defaultValue = "JESSIONID") String cookieValue){
        System.out.println("请求传来的参数为: " + username);
        System.out.println("请求头的信息为: " + userAgent);
        System.out.println("JESSIONID的值为: " + cookieValue);
        return "param";
    }

    /**
     * 自动将表单的信息封装对象成javabean,属性跟表单的name一致
     * 还支持级联封装,即javabean(形参)有引用类型,也会自动封装
     *      name="属性的属性"
     *
     * 请求的数据可能有乱码(在Filter中设置)
     *      请求乱码
     *          get请求:该tomcat配置 server.xml 在8080端口的标签中加上URIEncoding="UTF-8"
     *          post请求:在第一次获取请求参数之前设置  request.setCharacterEncoding("UTF-8")
     *      响应乱码
     *          response.setContentType("text/html;charset=UTF-8")
     *
     * @param account
     * @return
     */
    @RequestMapping("/params")
    public String getListParams(Account account){
        System.out.println("添加的账户为: " + account);
        return "param";
    }


}
