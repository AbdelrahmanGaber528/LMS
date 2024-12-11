package com.librarysystem.models;


public class Librarian extends User {
    private int librarianId;

    public Librarian(String userName, String password) {
        super(userName, password, "Librarian");
        this.librarianId = getUser_id();
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }
}
