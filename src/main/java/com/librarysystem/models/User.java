package com.librarysystem.models;

public  class User{
    private final Account account ;
    private String contact ;
    private String preferences;

    public User(String role){
        this("User",role);
    }
    public User(String name,String role) {
        this.account = new Account(name,"0000",role);
    }
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
}
