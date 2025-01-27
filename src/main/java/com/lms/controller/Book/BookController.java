package com.lms.controller.Book;

import com.lms.controller.Admin.BooksAdminController;

public class BookController {

    private static final BooksAdminController booksAdminController = new BooksAdminController();

    public static BooksAdminController getBooksAdminController(){
        return booksAdminController;
    }

}
