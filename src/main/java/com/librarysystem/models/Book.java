package com.librarysystem.models;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private String category;
    private boolean isAvailable = true;

    public Book(String title, String author ,String category){
        this.title = title;
        this.author = author;
        this.category = category;
    }
    public Book(int bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public String getBookId() {
        return String.valueOf(this.bookId);
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

