package com.librarysystem.models;

public class Account {

    // userName password isActive
    private static int accountID = 0;
    private String userName;
    private String password;
    private String role; // Example roles: "Admin", "Patron", "Librarian"
    private boolean isActive = false;

    // Constructor
    public Account(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        isActive = true;
        accountID++;
    }

    // authentication
    public boolean authenticate(String inputUsername, String inputPassword) {
        return this.userName.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public boolean hasRole(String role) {
        return this.role.equalsIgnoreCase(role);
    }

    public int getAccountID(){
        return accountID;
    }
    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }
    public boolean isActive(){
        return isActive;
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
