package com.louie.mapper;

import com.louie.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksMapper {
    //    增删改查业务
    int addBook(Books book);

    int deleteBook(@Param("bookID") int id);

    int updateBook(Books book);

    Books getBook(@Param("bookID") int id);

    List<Books> getAllBooks();
}
