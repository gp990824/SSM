package com.gp.mapper;

import com.gp.entity.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author gp
 * @create 2020/1/8 19:26
 */
public interface StudentMapper {
    //告知mybatis将其的snum字段作为key, 封装数据返回Map
    @MapKey("snum")
    Map<Integer, Student> queryStudentReturnMap();

    Student queryStudentByMap(Map<String, Object> map);

    Student queryStudentById(int id);

    boolean insertStudent(Student student);

    boolean deleteStudentById(int id);

    List<Student> queryAllStudent();

    boolean updateStudent(Student student);

    Student queryStudentByIdAndAge(@Param("id") int id, @Param("age") int age);
}
