package com.gp.mapper;

import com.gp.entity.Person;

import java.util.List;

/**
 * @author gp
 * @create 2019/12/26 14:29
 */
public interface PersonMapper {
    /*
    操作mybatis的接口:
    方法名和mapper.xml文件中的id值相同
    方法的参数类型和mapper.xml文件中标签的parameterType类型一致
    方法的返回值和mapper.xml文件 中resultType一致
     */
    Person queryPersonById(int id);
    void insertPerson(Person person);//如果没有返回值则返回类型为void
    void delPerson(int i);
    void updatePerson(Person person);
    List<Person> queryTotalPerson();
}
