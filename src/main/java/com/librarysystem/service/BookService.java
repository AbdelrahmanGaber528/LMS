package com.librarysystem.service;

import com.librarysystem.dao.BookDAO;
import com.librarysystem.models.Book;

public class BookService {
    private final BookDAO bookDAO;

    public BookService(){
        bookDAO = new BookDAO();
    }

    public void addNewBook(Book book){

    }
}
