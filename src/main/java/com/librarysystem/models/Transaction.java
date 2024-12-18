package com.librarysystem.models;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class Transaction {

    private int transactionId;
    private int bookId;
    private int userId;
    private LocalDate issueDate;
    private Date returnDate;
    private boolean isReturned;

    public Transaction(int transactionId, int bookId, int userId, Date returnDate, boolean isReturned) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.userId = userId;// Automatically set to the current date.
        this.returnDate = returnDate;
        this.isReturned = isReturned;
    }

    // Getter and Setter for transactionId
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    // Getter and Setter for bookId
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    // Getter and Setter for userId
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter and Setter for issueDate
    public LocalDate getIssueDate() {
        return issueDate;
    }


    // Getter and Setter for returnDate
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
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