package com.example.demo.service.impl;

import com.example.demo.DAO.BookDAO;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
// Service <-> DAO <-> DB
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public List<Book> getBooks(){
        return bookDAO.getAllBooks();
    }

    @Override
    @Transactional
    public void saveBook(Book book){
        bookDAO.saveBook(book);
    }

    @Override
    @Transactional
    public Book getBook(int id){
        return bookDAO.getBook(id);
    }

    @Override
    @Transactional
    public void deleteBook(int id){
        bookDAO.deleteBook(id);
    }

}
