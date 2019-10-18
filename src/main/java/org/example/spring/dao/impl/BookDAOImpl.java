package org.example.spring.dao.impl;

import org.example.spring.dao.BookDAO;
import org.example.spring.model.Book;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public long save(Book book) {
        em.persist(book);
        return book.getId();
    }

    @Override
    public Book get(long id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> list() {
        return em.createQuery("from Book", Book.class).getResultList();
    }

    @Override
    public void update(long id, Book book) {
        em.merge(book);
        em.flush();
    }

    @Override
    public void delete(long id) {
        Book bookDb = get(id);
        em.remove(bookDb);
    }
}
