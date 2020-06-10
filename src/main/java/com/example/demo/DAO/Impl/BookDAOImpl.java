package com.example.demo.DAO.Impl;

import com.example.demo.DAO.BookDAO;
import com.example.demo.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private String GET_ALL_BOOKS = "FROM Book";

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Book> getAllBooks() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery(GET_ALL_BOOKS);
        List<Book> bookList = query.getResultList();
        return bookList;

    }

    @Override
    public Book getBook(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Book.class, id);
    }

    @Override
    public void saveBook(Book book) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(book);
    }

    @Override
    public void deleteBook(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete FROM Book WHERE id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
