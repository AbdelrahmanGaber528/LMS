package com.lms.service.Book;

import com.lms.models.Book.Book;

public class EditBookService {

    public static void editBook(Book book){
        Book oldBook = BookService.getBookById(book.getBookId());
        if(oldBook == null){
            System.err.println("This Book Not Found.");
        }else{
            BookService.getBookDAO().updateBook(book);
        }
    }
}
