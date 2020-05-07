package com.gp.test;

import com.gp.entity.Account;
import com.gp.entity.Car;
import com.gp.entity.Page;
import com.gp.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author gp
 * @create 2020/2/2 15:35
 */
public class AccountTest {

    public static void testExecutorType() throws IOException {
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = build.openSession(ExecutorType.BATCH);
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        for (int i = 0; i < 10; i++) {
            int id = (int) (Math.random() * 100000);
            String substring = UUID.randomUUID().toString().substring(0, 2);
            int money = (int) (Math.random() * 100000);
            mapper.addAccountByExecutorType(new Account(id, substring, money));
        }
        sqlSession.commit();
        sqlSession.close();
        System.out.println("批量操作完成!");
    }

    public static void main(String[] args) throws IOException {
//       testExecutorType();
//        testprocedure();
        testEnum();
    }

    //测试存储函数
    public static void testprocedure() throws IOException {
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = build.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        Page page = new Page();
        //显示rownum >=1 && <=5的数据局
        page.setStart(1);
        page.setEnd(5);

        mapper.getPageAccount(page);

        System.out.println("总记录数: " + page.getCount());
        List<Account> accounts = page.getAccounts();
        for (Account account : accounts) {
            System.out.println("数据为: " + account);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //测试枚举类型
    public static void testEnum() throws IOException {
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = build.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("car", Car.FERRARI);
        map.put("name","a4");
        mapper.updatetEnumType(map);
        System.out.println("测试完成!");
        sqlSession.commit();
        sqlSession.close();
    }
}
