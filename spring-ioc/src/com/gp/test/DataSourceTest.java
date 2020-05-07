package com.gp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author gp
 * @create 2020/1/29 21:07
 */
public class DataSourceTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    //测试从ioc容器中拿c3p0连接池
    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = (DataSource) ioc.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }

}
