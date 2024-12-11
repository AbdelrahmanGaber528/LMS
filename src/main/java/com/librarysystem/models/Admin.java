package com.librarysystem.models;

// Admin class
public class Admin extends User {
    private int adminId;

    public Admin(String userName, String password) {
        super(userName, password, "Admin");
        this.adminId = getUser_id();
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}
