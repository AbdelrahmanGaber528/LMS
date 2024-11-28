package com.librarysystem.models;

public class Librarian extends User{
    @Override
    public boolean logIn(String id, String password) {
        return false;
    }

    @Override
    public boolean logOut() {
        return false;
    }

    @Override
    public boolean updateInformation(String contact, String preferences) {
        return false;
    }
}
