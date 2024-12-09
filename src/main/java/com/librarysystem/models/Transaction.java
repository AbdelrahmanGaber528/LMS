package com.librarysystem.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Transaction {

    private int transactionId = 0;
    private final Patron patron;  // Reference to Patron
    private final Librarian librarian;  // Reference to Librarian
    private double totalAmount ;
    private List<Book> books;
    private final LocalDateTime transactionTime;
    private String transactionType; // "Borrow" or "Return"

    public Transaction(Patron patron, Librarian librarian, double totalAmount,List<Book> books) {
        this.transactionId++;
        this.patron = patron;
        this.librarian = librarian;
        this.totalAmount = totalAmount;
        this.transactionTime = LocalDateTime.now(); // Set the current date and time
        this.books = books;
    }

    public double getTotalAmount(){ return this.totalAmount; }
    public void setTotalAmount(double totalAmount){ this.totalAmount = totalAmount;}
    public int getTransactionId() { return transactionId; }

//    public int getPatronId() { return this.patron.getAccountID(); }
//    public int getLibrarianId(){ return this.librarian.getAccountID();}
//    public String  getPatronName() { return this.patron.getName(); }
//    public String getLibrarianName(){ return this.librarian.getName();}

    public String getTransactionTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return transactionTime.format(formatter);
    }
    public String getType() { return transactionType; }
    public void setType(String transactionType) { this.transactionType = transactionType; }
}
