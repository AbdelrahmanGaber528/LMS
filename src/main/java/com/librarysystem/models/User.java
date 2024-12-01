package com.librarysystem.models;

public  class User{

    private String name ;
    private String contact ;
    private Account account ;
    private String preferences;
    private String membershipStatus;

    public User(){}

    public User(String name,String role) {
        setName(name);
        this.account = new Account("User","0000",role);
    }

    public int getAccountID(){
        return this.account.getAccountID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
