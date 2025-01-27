package com.lms.service.Book;

import com.lms.models.Book.Book;

public class DeleteBookService {

    public static boolean deleteBook(int id){
        Book book = BookService.getBookById(id);
        if(book != null) {
            BookService.getBookDAO().deleteBook(book);
            return true;
        }
        return false;
    }

}
