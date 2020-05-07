package com.gp.mapper;

import com.gp.entity.Dept;
import com.gp.entity.Employee;

import java.util.List;

/**
 * @author gp
 * @create 2020/1/9 15:36
 */
public interface DeptMapper {
     Dept queryDeptByDeptno(Integer deptno);
     Dept queryEmpByDeptno(Integer id);
     Dept queryEmpByDeptnoStep(Integer deptno);
}
