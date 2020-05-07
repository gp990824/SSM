package com.gp.dao;

import com.gp.bean.Employee;

import java.util.List;

/**
 * @author gp
 * @create 2020/2/6 9:46
 */
public interface EmployeeMapper {
   List<Employee> queryEmpAndDept();
   boolean insertEmp(Employee employee);
   boolean delEmpById(Integer id);
}
