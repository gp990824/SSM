package com.gp.mapper;

import com.gp.entity.Employee;

import java.util.List;

/**
 * @author gp
 * @create 2020/1/10 19:25
 */
//动态SQL
public interface EmployeeMapperDynamicSQL {
    List<Employee> queryEmployeeByAll(Employee employee);
    List<Employee> queryEmployeeByChoose(Employee employee);
    List<Employee> queryAllEmployees();
    boolean updateEmployee(Employee employee);
    List<Employee> queryEmployeeByList(List<Integer> list);
    int addEmployees(List<Employee> list);
//    int addEmployees(Employee employee);
}
