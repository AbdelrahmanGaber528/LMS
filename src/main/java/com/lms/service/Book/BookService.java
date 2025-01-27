package com.lms.service.Book;

import com.lms.dao.Book.BookDAO;
import com.lms.models.Book.Book;

public class BookService {

    private static final BookDAO bookDAO = new BookDAO();

    public static Book getBookById(int id){
        for(Book book : bookDAO.getALlBooks())
            if(book.getBookId() == id)
                return book;
        return null;
    }

    public static BookDAO getBookDAO(){
        return bookDAO;
    }

}
