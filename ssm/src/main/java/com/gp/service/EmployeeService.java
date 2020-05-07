package com.gp.service;

import com.gp.bean.Employee;
import com.gp.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gp
 * @create 2020/2/13 17:03
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    public List<Employee> getTotalEmpsAndDept(){
        return employeeMapper.queryEmpAndDept();
    }
}
