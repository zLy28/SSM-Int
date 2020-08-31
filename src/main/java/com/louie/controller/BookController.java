package com.louie.controller;

import com.louie.pojo.Books;
import com.louie.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> allBooks = bookService.getAllBooks();
        model.addAttribute("list", allBooks);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.getBook(id);
        System.out.println(books);
        model.addAttribute("book", books);
        return "updateBook";
    }

//    @RequestMapping("/toUpdateBook")
//    public String toUpdateBook(Model model, int id) {
//        Books books = bookService.queryBookById(id);
//        System.out.println(books);
//        model.addAttribute("book",books );
//        return "updateBook";
//    }

//    @RequestMapping("/updateBook")
//    public String updateBook(Books books, Model model) {
//        System.out.println(books);
//        bookService.updateBook(books);
//        Books book = bookService.getBook(books.getBookID());
//        model.addAttribute("book", book);
//        return "redirect:/book/allBook";
//    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.getBook(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id) {
        bookService.deleteBook(id);
        return "redirect:/book/allBook";
    }
}
