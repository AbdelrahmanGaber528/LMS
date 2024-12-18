package com.librarysystem.service;

import com.librarysystem.dao.BookDAO;
import com.librarysystem.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private final BookDAO bookDAO;

    public BookService(){
        bookDAO = new BookDAO();
    }

    public void addNewBook(Book book){

    }
    public List<Book> getAllBooks(){
        return bookDAO.getALlBooks();
    }
}
