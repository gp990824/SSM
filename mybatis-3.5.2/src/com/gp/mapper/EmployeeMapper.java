package com.gp.mapper;

import com.gp.entity.Employee;

import java.util.List;

/**
 * @author gp
 * @create 2020/1/9 15:01
 */
public interface EmployeeMapper {
    Employee queryEmployeeById(Integer id);
    Employee queryEmployeeByEmpno(Integer empno);
    List<Employee> queryEmployeeByDeptno(Integer deptno);
}
