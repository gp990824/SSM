package com.gp.controller;

/**
 * @author gp
 * @create 2020/2/4 18:07
 */

import com.gp.bean.Account;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC 用JSR303来做数据校验
 * JSR303:规范   Hibernate  Validator(第三方校验框架)
 * <p>
 * 步骤:导入jar包
 * 给javabean的属性添加注解即可
 * 校验结果如何判断:在Javabean参数后紧跟一个BindingResult参数即可,该对象即保存了校验的结果
 * 想要获取校验是否通过  1.在input标签后加上:<form:errors path="cardid"/>
 * 2.bindingResult.getFieldErrors() 返回List集合,每个集合的元素包含的每个属性的错误信息和属性名
 */
public class DataValidatorController {
    public String Validator(/*@Valid*/ Account account, BindingResult result, Map<String, Object> map) {
        boolean errors = result.hasErrors();
        HashMap<String, String> hashMap = new HashMap<>();
        List<FieldError> fieldErrors = result.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            hashMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        map.put("errorinfo", hashMap);//jsp页面通过el表达式${error.hashMap的key拿值)
        if (errors) {
            return "index";
        } else {
            return "success";
        }
    }
}
