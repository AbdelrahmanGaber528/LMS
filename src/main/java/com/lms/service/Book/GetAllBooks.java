package com.lms.service.Book;

import com.lms.models.Book.Book;
import java.util.List;

public class GetAllBooks {

    public static List<Book> getAllBooks(){
       return BookService.getBookDAO().getALlBooks();
    }

}
