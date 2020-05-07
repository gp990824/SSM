package com.gp.test;

import com.gp.entity.Account;
import com.gp.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author gp
 * @create 2020/2/1 20:59
 */
public class Source {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
//        System.out.println(mapper);//mapper为代理对象
        Account account = mapper.queryAccountByCardId(123456);
        System.out.println(account);
        sqlSession.commit();
        sqlSession.close();
    }
}
