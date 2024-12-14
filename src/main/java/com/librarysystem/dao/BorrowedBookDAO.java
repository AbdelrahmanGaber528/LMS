package com.librarysystem.dao;

import com.librarysystem.models.Book;
import com.librarysystem.util.LMSFileManager;

public class BorrowedBookDAO {

    LMSFileManager fileManager;

    public BorrowedBookDAO(){
        fileManager = new LMSFileManager("src\\main\\docs\\borrowedBooks.txt");
    }

    public void borrowBook(Book book){

    }
}
