package com.librarysystem.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private int transactionId = 0;
    private final String patronId;
    private final String librarianId;
    private int totalAmount ;
    private final LocalDateTime transactionTime;
    private String transactionType; // "Borrow" or "Return"

    public Transaction(String patronId, String librarianId, int totalAmount) {
        this.patronId = patronId;
        this.librarianId = librarianId;
        this.totalAmount = totalAmount;
        this.transactionTime = LocalDateTime.now();
    }
    public Transaction(int transactionId,String patronId, String librarianId, int totalAmount){
        this.transactionId = transactionId;
        this.patronId = patronId;
        this.librarianId = librarianId;
        this.totalAmount = totalAmount;
        this.transactionTime = LocalDateTime.now();
    }

    public void setTransactionId(int id ){
        this.transactionId = id;
    }
    public String getTransactionId() { return String.valueOf(this.transactionId); }

    public int getTotalAmount(){ return this.totalAmount; }
    public void setTotalAmount(int totalAmount){ this.totalAmount = totalAmount;}

    public String getTransactionTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return transactionTime.format(formatter);
    }
    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

    public String getLibrarianId(){ return this.librarianId;}
    public String getPatronId(){ return this.patronId;}
}
