package com.librarysystem.models;


public class Librarian extends User {

    private String librarianId;

    public Librarian(String userName, String password) {
        super(userName, password, "Librarian");
        this.librarianId = getUserID();
    }

    public String getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(String librarianId) {
        this.librarianId = librarianId;
    }

}
