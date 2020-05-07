package com.gp.service;

import com.gp.bean.Book;
import org.springframework.stereotype.Service;

/**
 * @author gp
 * @create 2020/1/30 16:14
 */
@Service
public class BookService extends BaseService<Book> {

    @Override
    public void save() {
        System.out.println("BookService被调用!");
    }
}
