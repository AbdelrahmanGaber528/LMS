package com.librarysystem.models;


public class Librarian extends User {

    private String librarianId;

    public Librarian(){}

    public Librarian(String userName, String password) {
        super(userName, password, "Librarian");
        this.librarianId = getUserID();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(String librarianId) {
        this.librarianId = librarianId;
    }

}
