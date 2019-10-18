package org.example.spring.dao;

import org.example.spring.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Book book) {
        sessionFactory.getCurrentSession().save(book);
        return book.getId();
    }

    @Override
    public Book get(long id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Override
    public List<Book> list() {
        return sessionFactory.getCurrentSession().createQuery("from Book", Book.class).list();
    }

    @Override
    public void update(long id, Book book) {
        Session currentSession = sessionFactory.getCurrentSession();
        Book bookDb = currentSession.byId(Book.class).load(id);
        bookDb.setTitle(book.getTitle());
        bookDb.setAuthor(book.getAuthor());
        currentSession.flush();
    }

    @Override
    public void delete(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Book bookDb = currentSession.byId(Book.class).load(id);
        currentSession.delete(bookDb);
    }
}
