package com.gp.test;

import com.gp.entity.Student;
import com.gp.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gp
 * @create 2020/1/8 19:29
 */
public class StudentTest {
    public static void main(String[] args) throws IOException {

        StudentTest test = new StudentTest();
        System.out.println(test.queryStudentById(20));
//        System.out.println(test.queryStudentByIdAndAge(56, 25));
        Map<String, Object> map = new HashMap<>();
        map.put("sname","曾狗");
        map.put("snum",56);
        System.out.println(test.queryStudentByMap(map));
        System.out.println("------------------");
        System.out.println(test.queryStudentReturnMap());
//        System.out.println(test.insertStudent(new Student(null, "yaya", 8, "erxiao")));
//        System.out.println(test.deleteStudentById(0));
//        List<Student> students = test.queryAllStudent();
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        System.out.println(test.updateStudent(new Student(11, "ll", 9, "jx")));
    }
    //根据id修改学生信息
    public boolean updateStudent(Student student) throws IOException {
        SqlSession sqlSession = getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        boolean b = mapper.updateStudent(student);
        sqlSession.commit();
        sqlSession.close();
        return b;
    }
    //查询学生返回一个map集合
    public Map<Integer,Student> queryStudentReturnMap() throws IOException {
        SqlSession session = getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Map<Integer, Student> map = mapper.queryStudentReturnMap();
        session.commit();
        session.close();
        return map;
    }
    //根据map查询学生
    public Student queryStudentByMap(Map<String, Object> map) throws IOException {
        SqlSession session = getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.queryStudentByMap(map);
        session.commit();
        session.close();
        return student;

    }
    //根据id和年龄查询学生
    public Student queryStudentByIdAndAge(int id,int age) throws IOException {
        SqlSession session = getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.queryStudentByIdAndAge(id, age);
        session.commit();
        session.close();
        return student;

    }
    //根据id删除学生
    public boolean deleteStudentById(int id) throws IOException {
        SqlSession session = getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        boolean b = mapper.deleteStudentById(id);
        session.commit();
        session.close();
        return b;
    }
    //查询所有学生
    public List<Student> queryAllStudent() throws IOException {
        SqlSession session = getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.queryAllStudent();
        session.commit();
        session.commit();
        return students;
    }
    //插入学生信息
    public boolean insertStudent(Student student) throws IOException {
        SqlSession session = getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        boolean b = mapper.insertStudent(student);
        session.commit();
        session.close();
        return b;
    }
    //根据id查找学生
    public Student queryStudentById(int id) throws IOException {
        SqlSession session = getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.queryStudentById(id);
        session.commit();
        session.close();
        return student;
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
