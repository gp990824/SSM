package com.gp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gp
 * @create 2020/2/1 13:31
 */
//@RequestMapping("/hello")//此类的所有方法都必须拦截此前缀的请求地址  localhost:8888/springmvc/hello/xxx
@Controller
public class FirstController {

    /*
    value:拦截请求地址
    method:请求方式(get post ... 默认全部接受)
    params:规定请求参数 params={"(!)username(!=admin)"}请求必须(不)带username(不等于admin)的参数
    headers:规定请求头,也能写简单的表达式 规定哪种浏览器有访问权限
            User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36
    consumes:只接受内容类型是哪种的请求,规定请求头中的Content-Type
    produces:告诉浏览器返回的内容类型是什么,给响应头中加上Content-Type
     */
    @RequestMapping(value = "/hello")
    public String firstRequest() {
        System.out.println("方法已进入!");
        return "first";
    }

    /*
    value的值还支持模糊匹配,有三种通配符(?  *  **)
    ? : 能替代一个字符
    * : 替代多个字符,和一层路径
    ** : 能替代多层路径
        遵循精确优先原则  /hello > /hellA(/hell?) > /hello123(/hell*) > /hello/单* > /hello双*
     */

    @RequestMapping("/hell?")//当存在/hello路径时,优先访问/hello路径,精确优先
    public String antTest() {
//        System.out.println("已进入ant方法!");
        return "first";
    }

    //路径上有占位符,占位符语法就是可以在任意路径的地方写一个{...} 相当有可变参数
    @RequestMapping("/hello/{name}")//只能占用一层路径
    public String pathVariable(@PathVariable("name") String name) {//second的值是从地址栏直接获得的
        System.out.println("-------------");
        System.out.println("Hello " + name);
        return "second";
    }

    @RequestMapping("/interceptor")
    public String testInterceptor(){
        System.out.println("正在执行testInterceptor方法!");
        return "first";
    }


}
