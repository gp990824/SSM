package com.gp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author gp
 * @create 2020/2/3 13:46
 */

/**
 * Rest风格:系统希望以非常简洁的URL地址来发请求
 * 怎样表示对一个资源的增删改查以请求方式来区分(get(查),post(增),put(改),delete(删))
 * <p>
 * 起名规范:/资源名/资源标识符
 * <p>
 * 如何使用put,delete请求方式
 *      <input name="_method" value="delete"/>
 * 注意:高版本的tomcat想要支持put,delete提交方式,并且使其成功转发到jsp页面
 *      必须在jsp页面加上<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
 */
@Controller
public class RestController {

    @RequestMapping(value = "/account/{cardid}", method = RequestMethod.GET)
    public String getAccount(@PathVariable("cardid") Integer id) {
        System.out.println("查询" + id + "账户");
        return "rest";
    }

    @RequestMapping(value = "/account/{cardid}", method = RequestMethod.PUT)
    public String putAccount(@PathVariable("cardid") Integer id) {
        System.out.println("修改" + id + "账户");
        return "rest";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String postAccount() {
        System.out.println("增加账户");
        return "rest";
    }
    @RequestMapping(value = "/account/{cardid}", method = RequestMethod.DELETE)
    public String deleteAccount(@PathVariable("cardid") Integer id) {
        System.out.println("删除" + id + "账户");
        return "rest";
    }

}
