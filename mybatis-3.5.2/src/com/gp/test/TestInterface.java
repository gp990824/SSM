package com.gp.test;

import com.gp.entity.Person;
import com.gp.mapper.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author gp
 * @create 2019/12/26 14:42
 */
public class TestInterface {

    /**
     * 注意sqlsession代表和数据库的一次会话,用完必须关闭
     * sqlsession和connection一样都是非线程安全的(不能将其设置为成员变量)
     * mapper接口没有实现类,但是mybatis会为接口生成代理对象
     * 将接口和xml配置文件进行绑定(将xml的namespace的id设置成接口的路径)
     * PersonMapper mapper = session.getMapper(PersonMapper.class);
     */


    //根据id查询
    public SqlSession getSqlSession() throws IOException {
        //加载mybatis配置文件
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //SqlSessionFactory - connection
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //session相当于connection
        SqlSession session = factory.openSession();
        return session;
    }
    public Person queryPersonById(int i) throws IOException {
        SqlSession session = getSqlSession();
        PersonMapper mapper = session.getMapper(PersonMapper.class);
        Person person = mapper.queryPersonById(i);
        session.close();
        return person;
    }
    //插入数据
    public void insertPerson() throws IOException {
        SqlSession session = getSqlSession();
        PersonMapper mapper = session.getMapper(PersonMapper.class);
        mapper.insertPerson(new Person(5, "ww", 28));
        session.commit();//提交事务
        session.close();
        System.out.println("插入成功!");
    }
    //删除
    public void delPerson(int i) throws IOException {
        SqlSession session = getSqlSession();
        PersonMapper mapper = session.getMapper(PersonMapper.class);
        mapper.delPerson(i);
        session.commit();//提交事务
        session.close();
        System.out.println("删除成功!");
    }
    //显示所有查询结果
    public List<Person> queryTotalPerson() throws IOException {
        SqlSession session = getSqlSession();
        PersonMapper mapper = session.getMapper(PersonMapper.class);
        List<Person> persons = mapper.queryTotalPerson();
        session.close();
        return persons;
    }
    //修改
    public void updatePerson() throws IOException {
        SqlSession session = getSqlSession();
        PersonMapper mapper = session.getMapper(PersonMapper.class);
        Person person = new Person(1, "zsnb", 60);
        mapper.updatePerson(person);
        session.commit();//提交事务
        session.close();
        System.out.println("修改成功!");
    }

    public static void main(String[] args) throws IOException {
        TestInterface test = new TestInterface();
//        Person person = test.queryPersonById(3);
//        System.out.println(person);
//        test.updatePerson();
        test.insertPerson();
//        test.delPerson(5);
//        System.out.println(test.queryTotalPerson());
    }
}
