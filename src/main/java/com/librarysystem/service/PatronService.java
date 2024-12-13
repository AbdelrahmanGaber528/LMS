package com.librarysystem.service;

public class PatronService implements UserActions{
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
