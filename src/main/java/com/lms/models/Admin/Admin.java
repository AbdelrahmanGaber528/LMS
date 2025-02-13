package com.lms.models.Admin;

import com.lms.models.User;

public class Admin extends User {

    private String adminId;

    public Admin(){}

    public Admin(String userName, String password) {
        super(userName, password, "Admin");
        this.adminId = getUserID();
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
