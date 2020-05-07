package com.gp.test;

import com.gp.entity.Employee;
import com.gp.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author gp
 * @create 2020/1/9 15:12
 */
public class TestEmployee {
    public static void main(String[] args) throws IOException {
        TestEmployee testEmployee = new TestEmployee();
        Employee employee = testEmployee.queryEmployeeById(7782);
        System.out.println(employee);
//        System.out.println(employee.getDept());
//        System.out.println("-------------------");
//        Employee employee1 = testEmployee.queryEmployeeByEmpno(7369);
//        System.out.println(employee1.getName());
//        System.out.println(employee1.getDept());

    }
    //queryEmployeeById,根据id查询出员工
    public Employee queryEmployeeById(Integer id) throws IOException {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryEmployeeById(id);
        session.commit();
        session.close();
        return employee;
    }
    public Employee queryEmployeeByEmpno(Integer empno) throws IOException {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryEmployeeByEmpno(empno);
        session.commit();
        session.close();
        return employee;
    }
    public SqlSession getSqlSession() throws IOException {
        //加载mybatis配置文件
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //SqlSessionFactory - connection
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //session相当于connection
        SqlSession session = factory.openSession();
        return session;
    }
}
