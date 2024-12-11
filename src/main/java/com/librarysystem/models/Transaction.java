package com.librarysystem.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Transaction {

    private int transactionId = 0;
    private final String patronId;
    private final String librarianId;
    private double totalAmount ;
    private List<Book> books;
    private final LocalDateTime transactionTime;
    private String transactionType; // "Borrow" or "Return"

    public Transaction(String patronId, String librarianId, double totalAmount,List<Book> books) {
        this.patronId = patronId;
        this.librarianId = librarianId;
        this.totalAmount = totalAmount;
        this.transactionTime = LocalDateTime.now(); // Set the current date and time
        this.books = books;
    }
    public Transaction(int transactionId,String patronId, String librarianId, double totalAmount,List<Book> books){
        this.transactionId = transactionId;
        this.patronId = patronId;
        this.librarianId = librarianId;
        this.totalAmount = totalAmount;
        this.transactionTime = LocalDateTime.now(); // Set the current date and time
        this.books = books;
    }
    public List<Book> getAllBooks(){
        return books;
    }

    public void setTransactionId(int id ){
        this.transactionId = id;
    }
    public String getTransactionId() { return String.valueOf(this.transactionId); }

    public double getTotalAmount(){ return this.totalAmount; }
    public void setTotalAmount(double totalAmount){ this.totalAmount = totalAmount;}

    public String getTransactionTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return transactionTime.format(formatter);
    }
    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

    public String getLibrarianId(){ return this.librarianId;}
    public String getPatronId(){ return this.patronId;}
}
