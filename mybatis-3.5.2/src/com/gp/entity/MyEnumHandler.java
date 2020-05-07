package com.gp.entity;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author gp
 * @create 2020/2/2 21:03
 */

/**
 * 自定义类型处理器,实现TypeHandler接口,必须在全局配置文件中注册
 * 将枚举类型的name属性存入数据库中
 */
public class MyEnumHandler implements TypeHandler<Car> {

    /**
     * 定义参数如何保存到数据库中
     * @param preparedStatement
     * @param i
     * @param car
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Car car, JdbcType jdbcType) throws SQLException {
        //设置其name属性存入数据中
        preparedStatement.setString(i,car.getName());
    }

    @Override
    public Car getResult(ResultSet resultSet, String s) throws SQLException {
        String name = resultSet.getString(s);
        Car car = Car.getCar(name);
        System.out.println(name);
        return car;
    }

    @Override
    public Car getResult(ResultSet resultSet, int i) throws SQLException {
        String name = resultSet.getString(i);
        Car car = Car.getCar(name);
        return car;
    }

    @Override
    public Car getResult(CallableStatement callableStatement, int i) throws SQLException {
        String name = callableStatement.getString(i);
        Car car = Car.getCar(name);
        return car;
    }
}
