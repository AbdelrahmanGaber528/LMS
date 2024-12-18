package com.librarysystem.service;

import com.librarysystem.dao.AdminDAO;
import com.librarysystem.models.Admin;
import com.librarysystem.models.Book;
import java.util.ArrayList;
import java.util.List;

public class AdminService implements UserActions{

    private final AdminDAO adminDAO;

    public AdminService(){
        adminDAO = new AdminDAO();
    }

    private boolean isFound(String id){
        List<Admin> adminList = adminDAO.getAllAdmins();
        for(Admin admin1 : adminList){
            if(admin1.getAdminId().equalsIgnoreCase(id))
                return true;
        }
        return false;
    }

    public void updateContact(String adminId , String newContact) {
        if(isFound(adminId))
        {
            Admin admin = getAdminById(adminId);
            admin.setContact(newContact);
            adminDAO.updateAdmin(admin);
        }
    }

    public void updateUserNamePassword(String id , String newUserName){
      if(isFound(id)){
          Admin admin = getAdminById(id);
          admin.getAccount().setUserName(newUserName);
          adminDAO.updateAdmin(admin);
      }
    }

    public void updatePassword(String id,String newPassword){
        if(isFound(id)){
            Admin admin = getAdminById(id);
            admin.getAccount().setPassword(newPassword);
            adminDAO.updateAdmin(admin);
        }
    }

    public void updatePreferences(String adminId , String newPreferences) {
        if(isFound(adminId))
        {
            Admin admin = getAdminById(adminId);
            admin.setPreferences(newPreferences);
            adminDAO.updateAdmin(admin);
        }
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

    public List<Admin> getAllAdmins(){
        return adminDAO.getAllAdmins();
    }
}
