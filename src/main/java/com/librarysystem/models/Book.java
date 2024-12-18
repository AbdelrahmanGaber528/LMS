package com.librarysystem.models;

import java.util.Date;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private String category;
    private String status ;
    private int amount ;
    private Date productionDate;
    public Book(String title, String author ,String category){
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = "available";
        this.amount++;
    }
    public Book(int bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = "available";
        this.amount++;
    }

    public Book(int id, String title, String author, String genre, String productionDate, boolean isAvailable) {

    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
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

    public String getStatus(){
        return this.status;
    }
    public void setId(int id){
        this.bookId = id;
    }
    public int getId(){
        return this.bookId;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}