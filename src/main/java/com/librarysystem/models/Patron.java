package com.librarysystem.models;
// Patron class
        import java.util.ArrayList;
        import java.util.List;

public class Patron extends User {
    private int patronId;
    private List<Book> borrowedBooks;

    public Patron(String userName, String password) {
        super(userName, password, "Patron");
        this.patronId = getUser_id();
        this.borrowedBooks = new ArrayList<>();
    }

    public int getPatronId() {
        return patronId;
    }

    public void setPatronId(int patronId) {
        this.patronId = patronId;
    }

    public List<Integer> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(int bookId) {
        if (!borrowedBooks.contains(bookId)) {
            borrowedBooks.add(bookId);
        }
    }

    public void returnBook(int bookId) {
        borrowedBooks.remove(Integer.valueOf(bookId));
    }
}

