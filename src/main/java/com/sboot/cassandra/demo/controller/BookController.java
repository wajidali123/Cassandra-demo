package com.sboot.cassandra.demo.controller;

import com.sboot.cassandra.demo.model.Book;
import com.sboot.cassandra.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping
    public Iterable<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @DeleteMapping("/{bookId}")
    public Iterable<Book> deleteBook(@PathVariable UUID bookId) {
        return bookService.deleteBook(bookId);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@RequestBody Book book, @PathVariable UUID bookId) {
        return bookService.updateBook(book, bookId);
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable UUID bookId) {
        return bookService.getBookById(bookId);
    }
}
