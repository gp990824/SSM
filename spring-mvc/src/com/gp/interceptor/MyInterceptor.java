package com.gp.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gp
 * @create 2020/2/4 20:48
 */

/**
 * 拦截器的执行顺序:拦截器preHandler->目标方法->postHandler->页面->afterHandler
 * 想要让SpringMVC感知拦截器,在配置文件中配置
 * 如果配置了多个拦截器,preHander方法则按照配置文件的顺序执行,而postHander则相反
 *      特别注意:无论后面的拦截器是否放行了,已放行的拦截器afterCompletion一定会执行
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 目标方法之前运行
     * @param request
     * @param response
     * @param handler
     * @return  是否放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了preHandler方法!");
        return true;
    }

    /**
     * 目标方法之后运行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行了postHandler方法!");
    }

    /**
     *页面来到之后运行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行了afterComplation方法!");
    }
}
