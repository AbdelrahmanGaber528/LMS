package com.lms.dao;

import com.lms.dao.Book.BookDAO;
import com.lms.models.Book.Book;
import org.junit.Test;

import java.time.LocalDate;

public class BookDAOTest {
    @Test
    public void testInsert(){
        BookDAO bookDAO = new BookDAO();
        Book testBook = new Book();
        testBook.setTitle("hello");
        testBook.setAmount(50);
        testBook.setCategory("History");
        testBook.setAuthor("Harryr");
        testBook.setProductionDate(LocalDate.EPOCH);
        testBook.setStatus("Avaliable");
        bookDAO.addNewBook(testBook);
    }

    @Test
    public void testGet(){
        BookDAO bookDAO = new BookDAO();
        for(Book book : bookDAO.getALlBooks())
            System.out.println(book.getCategory());
    }
}
