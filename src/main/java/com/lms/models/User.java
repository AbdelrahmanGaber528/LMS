package com.lms.models;

public abstract class User{

    private  Account account ;
    private String contact ;
    private String preferences;

    public User() {}

    public User(String userName ,String password, String role){
        this.account = new Account(userName,password,role);
    }

    public Account getAccount(){
        return this.account;
    }

    public String getUserID(){
        return String.valueOf(this.account.getAccountID());
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

    public  String toString(){
        return "ID: "+ this.getAccount().getAccountID() +" UserName: " + this.getAccount().getUserName() + "Role: "+ this.getAccount().getRole() + " Contact: "
                + this.getContact() + " Preferences:" + this.getPreferences();
    }

}
