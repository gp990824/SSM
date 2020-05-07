package com.gp.mapper;

import com.gp.entity.Account;
import com.gp.entity.Page;

import java.util.HashMap;


/**
 * @author gp
 * @create 2020/2/1 20:55
 */
public interface AccountMapper {
    Account queryAccountByCardId(Integer cardid);

    //不用动态SQL批量操作
    void addAccountByExecutorType(Account account);

    //利用Oracle中的存储过程实现分页
    void getPageAccount(Page page);

    //测试枚举类型
    void updatetEnumType(HashMap<String,Object> map);
}
