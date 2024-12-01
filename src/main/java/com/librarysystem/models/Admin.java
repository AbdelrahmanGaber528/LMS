package com.librarysystem.models;

public class Admin extends User{

    public Admin(){
        this("admin");
    }
    public Admin(String name){
        super(name,"Admin");
    }

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
