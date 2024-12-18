package com.librarysystem.service;

import com.librarysystem.dao.AdminDAO;
import com.librarysystem.models.Admin;
import com.librarysystem.models.Book;

import java.util.ArrayList;
import java.util.List;

public class AdminService {

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

    public void updateContact(Admin admin) {
        if(isFound(admin))
        {
            adminDAO.updateAdmin(admin);
        }
    }

    public void updateUserNamePassword(Admin admin){
       if(isFound(admin))
           adminDAO.updateAdmin(admin);
    }

    public Admin getAdminById(String id){
        List<Admin> admins = getAllAdmins();
        for(Admin admin : admins){
            if(admin.getAdminId().equalsIgnoreCase(id))
                return admin;
        }
        return null;
    }

//    public String checkStatus(Book book){ // we need the book service
//
//    }

    public List<Admin> getAdminByUserName(String userName){
        List<Admin> admins = getAllAdmins();
        List<Admin> adminList = new ArrayList<>();
        for(Admin admin : admins){
            if(admin.getAccount().getUserName().equalsIgnoreCase(userName))
                adminList.add(admin);
        }
        return adminList;
    }

    public void updatePreferences(Admin admin) {
        if(isFound(admin))
        {
            adminDAO.updateAdmin(admin);
        }
    }

    public List<Admin> getAllAdmins(){
        return adminDAO.getAllAdmins();
    }
}
