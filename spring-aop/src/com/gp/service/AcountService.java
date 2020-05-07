package com.gp.service;

import com.gp.dao.Acount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * @author gp
 * @create 2020/1/31 18:30
 */
@Service
public class AcountService {
    @Autowired
    Acount acount;

    /**
     * 事务:要么都成功,要么都失败
     *
     * @param name  姓名
     * @param money 要增加的钱
     * @return map
     */
    //有以下集中重要属性:    isolation 事务的隔离级别  propagation事务的传播行为,是否在执行该方法时开启新的事务,
    //                      以至于不影响大事务  rollbackFor 那些异常回滚
    /*
    运行时异常: 1/0 (默认回滚)
    编译时异常: throw exception  try catch(默认不回滚)
    使用noRollbackFor和rollbackFor可以指定默认的异常是否回滚
     */
    @Transactional()/*(noRollbackFor = {ArithmeticException.class})*/
    public HashMap<String, Object> check(String name, int money) {
        int update = acount.update(name, money);
        Integer gp = acount.query(name);
//        System.out.println(update);
        HashMap<String, Object> map = new HashMap<>();
        map.put("姓名", name);
        map.put("余额", gp);
        map.put("影响行数", update);
//        try {
//            new FileInputStream("C:\\aa.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        int i = 1 / 0;
        return map;
    }
}
