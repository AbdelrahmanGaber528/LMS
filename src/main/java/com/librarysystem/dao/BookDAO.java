package com.librarysystem.dao;

import com.librarysystem.models.Book;
import com.librarysystem.util.LMSFileManager;
import com.librarysystem.util.ColumnName;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class BookDAO {

    private final LMSFileManager bookFileManager = new LMSFileManager("src\\main\\docs\\Books.txt");
    private static int bookIdCounter = 0;

    public BookDAO() {
        File file = new File("src\\main\\docs\\bookIdCounter.txt");
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
            book.setId(newId);
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

    private Book createBook(Map<ColumnName, String> bookData) {
        int id = Integer.parseInt(bookData.get(ColumnName.BOOK_ID));
        String title = bookData.get(ColumnName.TITLE);
        String author = bookData.get(ColumnName.AUTHOR);
        String genre = bookData.get(ColumnName.GENRE);
        String productionDate = bookData.get(ColumnName.PRODUCTION_DATE);
        boolean isAvailable = Boolean.parseBoolean(bookData.get(ColumnName.IS_AVAILABLE));
        return new Book(id, title, author, genre, productionDate, isAvailable);
    }

    private Map<ColumnName, String> createBookMap(Book book) {
        Map<ColumnName, String> bookMap = new TreeMap<>();
        bookMap.put(ColumnName.BOOK_ID, String.valueOf(book.getId()));
        bookMap.put(ColumnName.TITLE, book.getTitle());
        bookMap.put(ColumnName.AUTHOR, book.getAuthor());
        bookMap.put(ColumnName.GENRE, book.getCategory());
        bookMap.put(ColumnName.PRODUCTION_DATE, String.valueOf(book.getProductionDate()));
        bookMap.put(ColumnName.IS_AVAILABLE, String.valueOf(book.getStatus()));
        return bookMap;
    }

    public int generateBookId() {
        bookIdCounter++;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\docs\\bookIdCounter.txt"))) {
            writer.write(String.valueOf(bookIdCounter));
        } catch (IOException e) {
            System.err.println("Can't write new book ID to file: " + e.getMessage());
        }
        return bookIdCounter;
    }
}