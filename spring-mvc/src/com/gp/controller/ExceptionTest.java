package com.gp.controller;

/**
 * @author gp
 * @create 2020/2/5 10:05
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 异常处理器:
 *      ExceptionHandlerExceptionResolver: @ExceptionHandler
 *      ResponseStatusExceptionResolver: @ResponseHandler
 *      DefaultHandlerExceptionResolver: 判断是否为SpringMVC自己的异常
 */
@Controller
public class ExceptionTest {

    @RequestMapping("/testExceptoin")
    public String testException(Integer i){
        System.out.println(1 / i);
        return "first";
    }

    //自定义异常,如果想要让其工作,必须先把所有的异常处理干掉
    @RequestMapping("/testMyexception")
    public String testMyexception(String username){
        if(!username.equals("admin")){
            throw new UserNameNotFoundException();
        }else {
            return "first";
        }
    }


}
