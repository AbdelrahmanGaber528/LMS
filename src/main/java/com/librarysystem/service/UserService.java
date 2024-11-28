package com.librarysystem.service;

public interface UserService {
    public boolean logIn(String id , String password);
    public boolean logOut();
    public boolean updateInformation(String contact, String preferences);
}
