package com.tien.ss06.service;

import com.tien.ss06.dao.BookDao;
import com.tien.ss06.dao.BookDaoImp;
import com.tien.ss06.model.Book;

import java.util.List;

public class BookServiceImp implements BookService {
    private final BookDao bookDao;

    public BookServiceImp() {
        bookDao = new BookDaoImp();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public List<Book> searchBooks(Integer id, String name) {
        return bookDao.searchBooks(id, name);
    }

    @Override
    public boolean save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book findById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public boolean delete(int id) {
        return bookDao.delete(id);
    }
}
