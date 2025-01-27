package com.lms.service.Book;

import com.lms.models.Book.Book;

public class SaveBookService {

    public static void saveBook(Book book){
        Book oldBook = BookService.getBookById(book.getBookId());
        if(oldBook == null){
            BookService.getBookDAO().addNewBook(book);
        }
        else
            System.err.println("Book is already exists.");
    }

}
