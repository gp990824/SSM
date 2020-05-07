package com.gp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author gp
 * @create 2020/2/4 10:40
 */

/**
 * 将数据带个jsp页面
 */
//给request中key等于modelandviewKEY且value的类型为String的数据存值,同时在session也放一个,推荐使用原生API给session存值
//@SessionAttributes(value = "modelandviewKEY", types = String.class)
@Controller
public class OutputToJspController {
    /**
     * 想要在session和request中保存数据,可以直接在参数上写上原生API(以下几种)
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     * Local:国际化有关的区域信息
     * InputString
     *      ServletInputString sis = request.getInputString()
     * OutputString
     *      ServletOutputString sos = response.getOutputString()
     * Reader
     *      Reader reader = request.getReader()
     * Writer
     *      Writer writer = response.getWriter()
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/output")
    public String useSession(HttpSession session, HttpServletRequest request){
        session.setAttribute("sessionValue","保存在session中的值!");
        request.setAttribute("requestValue","保存在request中的值!");
        return "output";
    }

    /**
     * spring MVC 提供了多种方式将数据传给jsp
     *      1.Map,Model,ModelMap这些参数,将数据保存在这些参数的域中,页面可以在页面获取
     *      这三种都会被放在request域中
     *      这三种类型实际上,都是org.springframework.validation.support.BindingAwareModelMap在工作
     *      相当于给org.springframework.validation.support.BindingAwareModelMap保存的值都会放在request域中
     *      前两种类型都是接口,ModelMap是类,继承了LinkedHashMap< String, Object>
     * @return
     */
    @RequestMapping("/springoutput")
    public String useSpringMVC(Map<String,Object> map, Model model, ModelMap modelMap){
        model.addAttribute("modelkey","modelvalue");
        modelMap.addAttribute("modelMapkey","modelMapvalue");
        map.put("mapkey","mapvalue");
        System.out.println("map的类型为:" + map.getClass());
        System.out.println("mode的类型为:" + model.getClass());
        System.out.println("modelMap的类型为:" + modelMap.getClass());
        return "output";
    }

    /**
     * 返回ModelAndView类型(参数为视图名),也可以用setView方法告知springMVC要转发到的视图地址
     * 同样可以将值存在该类的对象中,同样放在request域中
     * @return
     */
    @RequestMapping("/modelandview")
    public ModelAndView useModelAndView(){
        ModelAndView modelAndView = new ModelAndView("output");
        modelAndView.addObject("modelandviewKEY","modelandviewVALUE");
        return modelAndView;
    }
}
