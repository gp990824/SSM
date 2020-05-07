package com.gp.test;

import com.gp.entity.Employee;
import com.gp.mapper.EmployeeMapperDynamicSQL;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gp
 * @create 2020/1/10 19:44
 */
public class TestEmployeeDynamicSql {
    public static void main(String[] args) throws IOException {
        TestEmployeeDynamicSql testEmployeeDynamicSql = new TestEmployeeDynamicSql();
//        Employee employee = new Employee(null, "%S%", null);
//        Employee employee2 = new Employee(null, "%A%", null);
//        List<Employee> employees = testEmployeeDynamicSql.queryEmployeeByChoose(employee2);
//        List<Employee> employees = testEmployeeDynamicSql.queryAllEmployees();

//        List<Integer> integers = new ArrayList<>();
//        integers.add(5555);
//        integers.add(7369);
//        integers.add(7499);
//        List<Employee> employees = testEmployeeDynamicSql.queryEmployeeByList(integers);

//        for (Employee employee1 : employees) {
//            System.out.println(employee1);
//        }
//        Employee employee = new Employee(5555, "baba", "president");
//        System.out.println(testEmployeeDynamicSql.updateEmployee(employee));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(5888,"wocao","cleaner"));
//        employees.add(new Employee(5578,"wocao","cleaner"));
//        employees.add(new Employee(5658,"wocao","cleaner"));
//        employees.add(new Employee(5659,"wocao","cleaner"));
        System.out.println(testEmployeeDynamicSql.addEmployees(employees));
//        System.out.println(testEmployeeDynamicSql.addEmployees(new Employee(5888,"wocao","cleaner")));

    }

    public int addEmployees(List<Employee> employees) throws IOException {
        SqlSession session = getSqlSession();
        EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
        int b = mapper.addEmployees(employees);
        session.commit();
        session.close();
        return b;
    }

    public  List<Employee> queryEmployeeByList(List<Integer> list) throws IOException {
        SqlSession session = getSqlSession();
        EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
        List<Employee> emps = mapper.queryEmployeeByList(list);
        session.commit();
        session.close();
        return emps;
    }
    public boolean updateEmployee(Employee employee) throws IOException {
        SqlSession session = getSqlSession();
        EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
        boolean b = mapper.updateEmployee(employee);
        session.commit();
        session.close();
        return b;
    }

    public List<Employee> queryAllEmployees() throws IOException {
        SqlSession session = getSqlSession();
        EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
        List<Employee> emps = mapper.queryAllEmployees();
        session.commit();
        session.close();
        return emps;
    }
    public List<Employee> queryEmployeeByChoose(Employee employee) throws IOException {
        SqlSession session = getSqlSession();
        EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
        List<Employee> emps = mapper.queryEmployeeByChoose(employee);
        session.commit();
        session.close();
        return emps;
    }
    //测试动态sql
    public List<Employee> queryEmployeeByAll(Employee employee) throws IOException {
        SqlSession session = getSqlSession();
        EmployeeMapperDynamicSQL mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
        List<Employee> emps = mapper.queryEmployeeByAll(employee);
        session.commit();
        session.close();
        return emps;
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
