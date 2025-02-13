package com.lms.models;

public class Account {

    private String userName;
    private String id ;
    private String password;
    private String role;
    private boolean isActive = true;

    public Account(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public Account(){
    }

    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getAccountID(){
        return String.valueOf(this.id);
    }

    public String isActive(){
        if(this.isActive)
            return "True";
        return "False";
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
