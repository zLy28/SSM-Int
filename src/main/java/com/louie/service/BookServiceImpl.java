package com.louie.service;

import com.louie.mapper.BooksMapper;
import com.louie.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    public int addBook(Books book) {
        return booksMapper.addBook(book);
    }

    public int deleteBook(int id) {
        return booksMapper.deleteBook(id);
    }

    public int updateBook(Books book) {
        return booksMapper.updateBook(book);
    }

    public Books getBook(int id) {
        return booksMapper.getBook(id);
    }

    public List<Books> getAllBooks() {
        return booksMapper.getAllBooks();
    }
}
