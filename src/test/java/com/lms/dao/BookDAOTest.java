package com.lms.dao;

import com.lms.dao.Book.BookDAO;
import com.lms.models.Book.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BookDAOTest {
//    @Test
//    public void testInsert(){
//        BookDAO bookDAO = new BookDAO();
//        Book testBook = new Book();
//        testBook.setTitle("hello");
//        testBook.setAmount("50");
//        testBook.setCategory("History");
//        testBook.setAuthor("Harry");
//        testBook.setProductionDate(LocalDate.EPOCH);
//        testBook.setStatus("Available");
//        bookDAO.addNewBook(testBook);
////    }
    @Test
    public void testInsertMultipleBooks() {
        BookDAO bookDAO = new BookDAO();

        // Create multiple books
        Book book1 = new Book();
        book1.setTitle("1984");
        book1.setAmount("7");

        book1.setCategory("Fiction");
        book1.setAuthor("George Orwell");
        book1.setProductionDate(LocalDate.of(1949, 6, 8));
        book1.setStatus("Available");

        Book book2 = new Book();
        book2.setTitle("To Kill a Mockingbird");
        book2.setAmount("7");

        book2.setCategory("History");
        book2.setAuthor("Harper Lee");
        book2.setProductionDate(LocalDate.of(1960, 7, 11));
        book2.setStatus("Available");

        Book book3 = new Book();
        book3.setTitle("The Great Gatsby");
        book3.setAmount("7");
        book3.setCategory("Non Fiction");
        book3.setAuthor("F. Scott Fitzgerald");
        book3.setProductionDate(LocalDate.of(1925, 4, 10));
        book3.setStatus("Available");

        // Add books to the database
        bookDAO.addNewBook(book1);
        bookDAO.addNewBook(book2);
        bookDAO.addNewBook(book3);

    }
//    @Test
//    public void testGet(){
//        BookDAO bookDAO = new BookDAO();
//        for(Book book : bookDAO.getALlBooks())
//            System.out.println(book.getCategory());
//    }
}
