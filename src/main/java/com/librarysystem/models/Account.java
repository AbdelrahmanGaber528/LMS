package com.librarysystem.models;

public class Account {

    private String userName;
    private int id ;
    private String password;
    private String role; // Example roles: "Admin", "Patron", "Librarian"
    private boolean isActive = true;

    public Account(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
    //  loading an existing account and unique id in dao
    public Account(int id, String userName, String password, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public boolean hasRole(String role) {
        return this.role.equalsIgnoreCase(role);
    }

    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getAccountID(){
        return String.valueOf(this.id);
    }

    public String isActive(){
        return String.valueOf(this.isActive);
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
