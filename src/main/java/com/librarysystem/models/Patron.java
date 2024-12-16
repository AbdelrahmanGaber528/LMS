package com.librarysystem.models;

public class Patron extends User {
    private String patronId;

    public Patron(){}

    public Patron(String userName, String password) {
        super(userName, password, "Patron");
        this.patronId = getUserID();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getPatronId() {
        return patronId;
    }

    public void setPatronId(String patronId) {
        this.patronId = patronId;
    }

}

