package com.sboot.cassandra.demo.service;

import com.sboot.cassandra.demo.model.Book;
import com.sboot.cassandra.demo.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        book.setId(UUID.randomUUID()); // Generate unique ID for each book
        return bookRepository.save(book);
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Book> deleteBook(UUID bookId) {
        Optional<Book> book = bookRepository.findById(String.valueOf(bookId));
        if(book.isPresent()) {
            bookRepository.delete(book.get());
        }
        return bookRepository.findAll();
    }

    public Book updateBook(Book book, UUID bookId) {
        Optional<Book> existingBook = bookRepository.findById(String.valueOf(bookId));
        if(existingBook.isPresent()) {
            Book updatedBook = existingBook.get();
            updatedBook.setTitle(book.getTitle());
            updatedBook.setImageUrl(book.getImageUrl());
            updatedBook.setPrice(book.getPrice());
            return bookRepository.save(updatedBook);
        }
        return bookRepository.findById(String.valueOf(book.getId())).get();
    }

    public Book getBookById(UUID bookId) {
        return bookRepository.findById(String.valueOf(bookId)).get();
    }
}