package com.gp.controller;

/**
 * @author gp
 * @create 2020/2/5 10:25
 */

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 集中处理所有异常,精确优先,如果异常出现在其他的类,且有异常处理方法,优先执行他
 */
@ControllerAdvice
public class MyExceptionHandler {
    /**
     * 告知SpringMVC这个方法专门处理这个类发生的异常
     * @param e  用来接受发生的异常
     * @return  返回ModelAndView来保存异常并发送到指定页面
     */
    @ExceptionHandler(value = {Exception.class})
    public ModelAndView test(Exception e){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorinfo",e);
        return modelAndView;
    }
}
