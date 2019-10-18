package org.example.spring.controller;

import org.example.spring.model.Book;
import org.example.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/api/book")
    public ResponseEntity<List<Book>> list() {
        List<Book> books = bookService.list();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/api/book/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") long id) {
        Book book = bookService.get(id);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/api/book")
    public ResponseEntity<String> save(@RequestBody Book book) {
        long id = bookService.save(book);
        return ResponseEntity.ok().body(String.format("Book created with id %d", id));
    }

    @PutMapping("/api/book/{id}")
    public ResponseEntity<String> update(@PathVariable("id") long id, @RequestBody Book book) {
        bookService.update(id, book);
        return ResponseEntity.ok().body(String.format("Book with id %d has been updated", id));
    }

    @DeleteMapping("/api/book/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        bookService.delete(id);
        return ResponseEntity.ok().body(String.format("Book with id %d has been deleted", id));
    }
}
