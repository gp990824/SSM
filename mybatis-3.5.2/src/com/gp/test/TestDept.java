package com.gp.test;

import com.gp.entity.Dept;
import com.gp.mapper.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author gp
 * @create 2020/1/9 15:39
 */
public class TestDept {
    public static void main(String[] args) throws IOException {
        TestDept testDept = new TestDept();
        System.out.println(testDept.queryDeptByDeptno(10));
//        Dept dept = testDept.queryEmpByDeptno(10);
        System.out.println("------------------");
//        System.out.println(dept.getName());
//        List<Employee> empList = dept.getEmpList();
//        for (Employee employee : empList) {
//            System.out.println(employee);
//        }
        Dept dept = testDept.queryEmpByDeptnoStep(10);
        System.out.println(dept.getName());
        System.out.println(dept.getEmpList());
    }
    public Dept queryEmpByDeptnoStep(Integer deptno) throws IOException {
        SqlSession session = getSqlSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = mapper.queryEmpByDeptnoStep(deptno);
        session.commit();
        session.close();
        return dept;
    }
    public Dept queryDeptByDeptno(Integer deptno) throws IOException {
        SqlSession session = getSqlSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = mapper.queryDeptByDeptno(deptno);
        session.commit();
        session.close();
        return dept;
    }
    public Dept queryEmpByDeptno(Integer id) throws IOException {
        SqlSession session = getSqlSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = mapper.queryEmpByDeptno(id);
        session.commit();
        session.close();
        return dept;
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
