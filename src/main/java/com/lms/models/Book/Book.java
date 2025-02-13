package com.lms.models.Book;

import java.time.LocalDate;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private String category;
    private String status = "Available";
    private String amount = "0" ;
    private LocalDate productionDate;


    // constructors

    public Book(String title, String author ,String category){
        this.title = title;
        this.author = author;
        this.category = category;
        this.productionDate = LocalDate.now();
    }

    public Book(){
        this.productionDate = LocalDate.now();
    }

    public Book( String title, String author, String category,String amount) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = "available";
        this.productionDate = LocalDate.now();
        this.amount = amount;
    }


    // getters and setters

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }


    public void setBookId(String bookId) {
        this.bookId = Integer.parseInt(bookId);
    }

    public int getBookId() {
        return bookId;
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

    public void setStatus(String status) {
        this.status = status;
    }


    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

}