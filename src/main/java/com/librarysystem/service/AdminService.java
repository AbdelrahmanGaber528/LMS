package com.librarysystem.service;

import com.librarysystem.dao.AdminDAO;
import com.librarysystem.models.Admin;

import java.util.List;

public class AdminService implements UserActions{

    private final AdminDAO adminDAO;

    public AdminService(){
        adminDAO = new AdminDAO();
    }


    private boolean isFound(Admin admin){
        List<Admin> adminList = adminDAO.getAllAdmins();
        for(Admin admin1 : adminList){
            if(admin1.getAdminId().equalsIgnoreCase(admin.getAdminId()))
                return true;
        }
        return false;
    }

    @Override
    public void updateContact(String contactInfo) {

    }

    @Override
    public void updatePreferences(String preferences) {

    }
    public List<Admin> getAllAdmins(){
        return adminDAO.getAllAdmins();
    }
}
