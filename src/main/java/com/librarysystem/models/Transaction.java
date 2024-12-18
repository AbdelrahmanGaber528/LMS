package com.librarysystem.models;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class Transaction {

    private int transactionId;
    private String bookId;
    private String userId;

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    private  LocalDate issueDate;
    private LocalDate returnDate;
    private boolean isReturned;

    public Transaction(int transactionId, String bookId, String userId, LocalDate returnDate, boolean isReturned) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.userId = userId;// Automatically set to the current date.
        this.returnDate = returnDate;
        this.isReturned = isReturned;
        this.issueDate = LocalDate.now();
    }
    public Transaction(){
        this.issueDate = LocalDate.now();
    }
    // Getter and Setter for transactionId
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    // Getter and Setter for bookId
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }


    // Getter and Setter for userId
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Getter and Setter for issueDate
    public LocalDate getIssueDate() {
        return issueDate;
    }


    // Getter and Setter for returnDate
    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    // Getter and Setter for isReturned
    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}