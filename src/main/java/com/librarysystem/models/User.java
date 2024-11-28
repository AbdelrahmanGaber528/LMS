package com.librarysystem.models;

import com.librarysystem.service.UserService;

public abstract class User implements UserService {

    private String userName ;
    private String password ;
    private String contact ;
    private int id ;
    private String preferences;

    public int getId(){
        return this.id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
}
