package com.louie.service;

import com.louie.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    int addBook(Books book);

    int deleteBook(int id);

    int updateBook(Books book);

    Books getBook(int id);

    List<Books> getAllBooks();
}
