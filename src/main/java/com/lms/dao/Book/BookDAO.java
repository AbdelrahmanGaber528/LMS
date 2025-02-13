package com.lms.dao.Book;

import com.lms.models.Book.Book;
import com.lms.util.LMSFileManager;
import com.lms.util.ColumnName;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BookDAO {

    private final LMSFileManager bookFileManager;
    private static int bookIdCounter = 0;

    public BookDAO() {
        bookFileManager  = new LMSFileManager("src/main/docs/Book.txt");
        File file = new File("src/main/docs/bookIdCounter.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                bookIdCounter = Integer.parseInt(reader.readLine().trim());
            } catch (IOException e) {
                System.err.println("Can't read the book ID from file: " + e.getMessage());
            }
        }
    }

    public void addNewBook(Book book) {
        try {
            int newId = generateBookId();
            book.setBookId(String.valueOf(newId));
            bookFileManager.insertRow(createBookMap(book));
        } catch (IOException e) {
            System.err.println("Problem in adding book: " + e.getMessage());
        }
    }

    public void updateBook(Book book) {
        bookFileManager.updateRow(createBookMap(book));
    }

    public void deleteBook(Book book) {
        bookFileManager.deleteRow(createBookMap(book));
    }

    public List<Book> getALlBooks(){
            List<Book> books = new ArrayList<>();
        try{
            List<String> rows =  bookFileManager.getAllRows();
            for(int i = 1;i<rows.size();i++){
                String b = rows.get(i);
                Book book = createBookFromString(b);
                books.add(book);
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        return books;
    }

    private Map<ColumnName, String> createBookMap(Book book) {
        Map<ColumnName, String> bookMap = new TreeMap<>();
        bookMap.put(ColumnName.BOOK_ID, String.valueOf(book.getBookId()));
        bookMap.put(ColumnName.BOOK_TITLE, book.getTitle());
        bookMap.put(ColumnName.AUTHOR, book.getAuthor());
        bookMap.put(ColumnName.AMOUNT,String.valueOf(book.getAmount()));
        bookMap.put(ColumnName.GENRE, book.getCategory());
        bookMap.put(ColumnName.PRODUCTION_DATE,String.valueOf(book.getProductionDate()));
        bookMap.put(ColumnName.IS_AVAILABLE, book.getStatus());
        return bookMap;
    }

    private Book createBookFromString(String row){
        String[] details = row.split("\t");
        Book book = new Book();
        book.setBookId(details[0]);
        book.setTitle(details[1]);
        book.setAuthor(details[2]);
        book.setCategory(details[3]);
        book.setProductionDate(LocalDate.parse(details[4]));
        book.setStatus(details[5]);
        book.setAmount(details[6]);

        return book;
    }

    public int generateBookId() {
        bookIdCounter++;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/docs/bookIdCounter.txt"))) {
            writer.write(String.valueOf(bookIdCounter));
        } catch (IOException e) {
            System.err.println("Can't write new book ID to file: " + e.getMessage());
        }
        return bookIdCounter;
    }
}