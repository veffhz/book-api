package org.example.spring.service;

import org.example.spring.dao.BookDAO;
import org.example.spring.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public long save(Book book) {
        return bookDAO.save(book);
    }

    @Override
    public Book get(long id) {
        return bookDAO.get(id);
    }

    @Override
    public List<Book> list() {
        return bookDAO.list();
    }

    @Override
    public void update(long id, Book book) {
        bookDAO.update(id, book);
    }

    @Override
    public void delete(long id) {
        bookDAO.delete(id);
    }
}
