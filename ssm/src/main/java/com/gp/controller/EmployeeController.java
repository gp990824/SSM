package com.gp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gp.bean.Employee;
import com.gp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author gp
 * @create 2020/2/13 16:02
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")
    public String getTotalEmp(@RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                              Map<String, Object> map) {
        //使用分页插件,如果没有传参数,就默认显示第一页
        PageHelper.startPage(pageno, 10);
        List<Employee> emps = employeeService.getTotalEmpsAndDept();
        //pageinfo封装了详细的分页信息,包括我们查询出来的数据  第二个参数:连续显示的页数
        PageInfo pageInfo = new PageInfo(emps, 5);
        map.put("pageinfo", pageInfo);
        return "list";
    }
}
