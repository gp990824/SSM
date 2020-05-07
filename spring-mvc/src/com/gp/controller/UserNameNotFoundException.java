package com.gp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author gp
 * @create 2020/2/5 10:39
 */

/**
 * 自定义异常,如果想要让其工作,必须先把所有的异常处理干掉
 */
@ResponseStatus(reason = "用户不存在,拒绝登录!", value = HttpStatus.NOT_ACCEPTABLE)
public class UserNameNotFoundException extends RuntimeException {
}
