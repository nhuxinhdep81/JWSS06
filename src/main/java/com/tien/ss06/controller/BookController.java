package com.tien.ss06.controller;

import java.io.IOException;
import java.util.List;

import com.tien.ss06.model.Book;
import com.tien.ss06.service.BookService;
import com.tien.ss06.service.BookServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "BookController", value = "/BookController")
public class BookController extends HttpServlet {

    private final BookService bookService;

    public BookController() {
        bookService = new BookServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null || action.equals("getAll")) {
            getAllBooks(request, response);
        } else if (action.equals("search")) {
            searchBooks(request, response);
        } else if (action.equals("initUpdate")) {
            int id = Integer.parseInt(request.getParameter("bookId"));
            Book book = bookService.findById(id);
            if (book != null) {
                request.setAttribute("book", book);
                request.getRequestDispatcher("views/b1/formEdit.jsp").forward(request, response);
            }
        }else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("bookId"));
            boolean result = bookService.delete(id);
            if (result) {
                getAllBooks(request, response);
            }else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String action = request.getParameter("action");
        if(action.equals("search")){
            searchBooks(request, response);
        }else if(action.equals("add")){
            Book book = new Book();
            book.setBookName(request.getParameter("bookName"));
            book.setAuthor(request.getParameter("author"));
            book.setQuantity(Integer.parseInt(request.getParameter("quantity")));

            boolean result = bookService.save(book);
            if(result){
                getAllBooks(request, response);
            }else{
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        }else if(action.equals("update")){
            Book book = new Book();
            book.setBookId(Integer.parseInt(request.getParameter("bookId")));
            book.setBookName(request.getParameter("bookName"));
            book.setAuthor(request.getParameter("author"));
            book.setQuantity(Integer.parseInt(request.getParameter("quantity")));

            boolean result = bookService.update(book);
            if(result){
                getAllBooks(request, response);
            }else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        }
    }

    private void getAllBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> listBooks = bookService.getAllBooks();
        request.setAttribute("listBooks", listBooks);
        request.getRequestDispatcher("views/b1/listBook.jsp").forward(request, response);
    }

    private void searchBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idRaw = request.getParameter("bookId");
        String name = request.getParameter("bookName");

        Integer bookId = null;
        try {
            if (idRaw != null && !idRaw.trim().isEmpty()) {
                bookId = Integer.parseInt(idRaw);
            }
        } catch (NumberFormatException e) {
        }

        List<Book> searchResults = bookService.searchBooks(bookId, name);
        request.setAttribute("listBooks", searchResults);
        request.getRequestDispatcher("views/b1/listBook.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        // Dọn dẹp tài nguyên nếu cần
    }
}
