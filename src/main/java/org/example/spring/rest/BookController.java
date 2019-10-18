package org.example.spring.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.example.spring.model.Book;
import org.example.spring.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/api/book")
    public ResponseEntity<List<Book>> list() {
        log.info("Get list books");
        List<Book> books = bookService.list();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/api/book/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") long id) {
        log.info("Get book {}", id);
        Book book = bookService.get(id);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/api/book")
    public ResponseEntity<String> save(@RequestBody Book book) {
        log.info("Save book {}", book);
        long id = bookService.save(book);
        return ResponseEntity.ok().body(String.format("Book created with id %d", id));
    }

    @PutMapping("/api/book/{id}")
    public ResponseEntity<String> update(@PathVariable("id") long id, @RequestBody Book book) {
        log.info("Update book {}, book {}", id, book);
        bookService.update(id, book);
        return ResponseEntity.ok().body(String.format("Book with id %d has been updated", id));
    }

    @DeleteMapping("/api/book/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        log.info("Delete book {}", id);
        bookService.delete(id);
        return ResponseEntity.ok().body(String.format("Book with id %d has been deleted", id));
    }
}
