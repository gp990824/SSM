package com.gp.controller;

/**
 * @author gp
 * @create 2020/2/4 19:11
 */

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * spring MVC支持Ajax
 *  导包
 *      jackon包
 *      在方法加上@ResponseBody,客户端发送ajax请求,服务端就会返回json数据
 *  如何用ajax发送就送数据,请看网上视屏教学
 *      RequestBody:把对象转成json数据,并返回给客户端
 *      ResponseBody:接受json数据,封装为对象
 */
@Controller
public class AjaxController {
    /**
     * 测试RequestBody注解,注意:请求方式必须为post
     * @param body
     * @return
     */
    @RequestMapping("/requestBody")
    public String requestBody(@RequestBody String body){
        //如何将请求体封装成javabean,请看网上视屏教学
        System.out.println("请求体: " + body);
        return "first";
    }

    /**
     * 如果参数为HttpEntity  可以拿到请求头和请求体
     * @param httpEntity
     * @return
     */
    @RequestMapping("/httpEntity")
    public String httpEntiry(HttpEntity<String> httpEntity){
        System.out.println("HttpEntity: " + httpEntity);
        return "first";
    }

    /**
     * 测试Response注解,不会跳转页面,直接将first放在响应体中
     * @return
     */
    @ResponseBody
    @RequestMapping("/testResponseBody")
    public String testResponseBody(){
        System.out.println("方法已进入!");
        return "first";
    }
    /**
     * 可以使用返回类型为ResponseEntity<T>来定制响应头
     */
}
