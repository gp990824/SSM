package com.gp.test;


import com.gp.entity.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author gp
 * @create 2019/12/25 23:03
 */
public class Test {
    //加载mybatis配置文件
    Reader reader = null;
    //SqlSessionFactory - connection
    SqlSessionFactory factory = null;
    //session相当于connection
    SqlSession session = null;

    //根据id查询
    public Person queryPersonById(int i) throws IOException {
        reader = Resources.getResourceAsReader("conf.xml");
        factory = new SqlSessionFactoryBuilder().build(reader);
        session = factory.openSession();
        String sql = "com.gp.entity.Person.personMapper.queryPersonById";
        Person person = session.selectOne(sql,i);
        session.close();
        return person;
    }

    //插入数据
    public int insertPerson() throws IOException {
        reader = Resources.getResourceAsReader("conf.xml");
        factory = new SqlSessionFactoryBuilder().build(reader);
        session = factory.openSession();
        String sql = "com.gp.entity.Person.personMapper.insertPerson";
        Person person1 = new Person(2, "ls", 25);
        int result = session.insert(sql, person1);
        session.commit();//提交事务
        session.close();
        return result;
    }
    //删除
    public int delPerson(int i) throws IOException {
        reader = Resources.getResourceAsReader("conf.xml");
        factory = new SqlSessionFactoryBuilder().build(reader);
        session = factory.openSession();
        String sql = "com.gp.entity.Person.personMapper.delPerson";
        int result = session.delete(sql, i);
        session.commit();//提交事务
        session.close();
        return result;
    }
    //显示所有查询结果
    public List<Person> queryTotalPerson() throws IOException {
        reader = Resources.getResourceAsReader("conf.xml");
        factory = new SqlSessionFactoryBuilder().build(reader);
        session = factory.openSession();
        String sql = "com.gp.entity.Person.personMapper.queryTotalPerson";
        List<Person> persons = session.selectList(sql);
        session.close();
        return persons;
    }
    //修改
    public int updatePerson() throws IOException {
        reader = Resources.getResourceAsReader("conf.xml");
        factory = new SqlSessionFactoryBuilder().build(reader);
        session = factory.openSession();
        String sql = "com.gp.entity.Person.personMapper.updatePerson";
        Person person = new Person(1, "zssb", 30);
        int result = session.update(sql,person);
        session.commit();//提交事务
        session.close();
        return result;
    }

    public static void main(String[] args) throws IOException {
        Test test = new Test();
//        System.out.println(test.queryPersonById(1));
//        System.out.println(test.insertPerson());
//        System.out.println(test.delPerson(2));
//        System.out.println(test.queryTotalPerson());
        System.out.println(test.updatePerson());
    }
}
