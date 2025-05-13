package com.tien.ss06.service;

import com.tien.ss06.model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    List<Book> searchBooks(Integer id, String name);
    boolean save(Book book);
    Book findById(int id);
    boolean update(Book book);
    boolean delete(int id);
}