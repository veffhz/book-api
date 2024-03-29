package org.example.spring.dao;

import org.example.spring.model.Book;

import java.util.List;

public interface BookDAO {
    long save(Book book);
    Book get(long id);
    List<Book> list();
    void update(long id, Book book);
    void delete(long id);
}
