package com.example.demo.controller;

import com.example.demo.ExceptionHandler.BookNotFoundException;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller <-> Service <-> DAO <-> db
@RestController
@RequestMapping("/api")
public class CRUD_API {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId) {
        Book book = bookService.getBook(bookId);

        if(book == null) {
            throw new BookNotFoundException("Book id not found - " + bookId);
        }

        return book;
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        book.setId(0);
        bookService.saveBook(book);
    }

    @PutMapping("/books")
    public void updateBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable int bookId) {
        Book book = bookService.getBook(bookId);

        if(book == null) {
            throw new BookNotFoundException("This book doesn't exist!");
        }
        bookService.deleteBook(bookId);
    }
}
