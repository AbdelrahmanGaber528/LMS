package com.lms.models.Transaction;

import java.time.*;

public class Transaction {

    private int transactionId;
    private String bookId;
    private String patronId;
    private  LocalDate issueDate;
    private LocalDate returnDate;
    private boolean isReturned;

    public Transaction(int transactionId, String bookId, String patronId, LocalDate returnDate, boolean isReturned) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.patronId = patronId;
        this.returnDate = returnDate;
        this.isReturned = isReturned;
        this.issueDate = LocalDate.now();
    }
    public Transaction(){
        this.issueDate = LocalDate.now();
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getPatronId() {
        return patronId;
    }

    public void setPatronId(String patronId) {
        this.patronId = patronId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}