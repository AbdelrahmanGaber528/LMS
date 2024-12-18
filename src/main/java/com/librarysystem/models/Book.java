package com.librarysystem.models;

import java.time.LocalDate;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private String category;
    private String status ;
    private int amount ;
    private LocalDate productionDate;

    public Book(String title, String author ,String category){
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = "available";
        this.productionDate = LocalDate.now();
        this.amount++;
    }
    public Book(int bookId, String title, String author, String category,int amount) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = "available";
        this.productionDate = LocalDate.now();
        this.amount = amount;
    }
    public Book(){
        this.productionDate = LocalDate.now();
    }

    public Book(int bookId, String title, String author, String category,String status) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = status;
        this.productionDate = LocalDate.now();
        this.amount++;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
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

    public String getStatus(){
        return this.status;
    }

    public void setId(int id){
        this.bookId = id;
    }
    public int getId(){
        return this.bookId;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}