package com.gp.controller;

/**
 * @author gp
 * @create 2020/2/4 11:59
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图解析器,不管是利用请求转发和重定向,后面的视图页面都默认是web目录下的视图页面
 * 有前缀(forward,redirect)的请求转发和重定向的跳转,配置的视图解析器不会生效
 *
 *  原理:无论返回值是String , Model还是modelAndView,springMVC最终创建的都是ModelAndView对象,然后得到视图解析器对象
 *  视图解析器只是为了得到视图对象,视图对象才能真正的转发(将模型数据全部放在request域中)或者重定向到页面
 *  视图对象才能真正的渲染视图
 */
@Controller
public class ViewResolverController {

    /**
     * 使用forward:...  可以请求转发到某个页面
     * @return
     */
    @RequestMapping("/useforward")
    public String userforward(){
//        return "forward:/hello";//转发到/hello请求
        return "forward:/viewresolver.jsp";//转发到该页面(不是WEB-INF目录中的)
//        return "../../viewresolver";//回退两层,web目录下的页面
//        return "viewresolver";
    }

    /**
     * 使用redirect:..  可以重定向到某个页面
     * @return
     */
    @RequestMapping("/useredirect")
    public String useredirect(){
        //原生的servlet需要加上项目名,springMVC会自动为我们拼接项目名
//        return "redirect:/viewresolver.jsp";
        return "redirect:/hello";
    }

}
