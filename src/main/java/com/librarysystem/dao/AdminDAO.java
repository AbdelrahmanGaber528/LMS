package com.librarysystem.dao;

import com.librarysystem.models.Admin;
import com.librarysystem.util.LMSFileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
    LMSFileManager adminFileManager = new LMSFileManager("src\\main\\docs\\Admin.txt");
    AccountDAO adminAccount = new AccountDAO();

    public AdminDAO(){}

    public List<Admin> getAllAdmins(){
        try{
            List<String> accounts = adminFileManager.getAllRows();
            List<Admin> admins = new ArrayList<>();
            for(String account : accounts){
                admins.add(createAdminFromString(account));
            }
            return admins;
        }catch (IOException e){
            System.err.println("Error in get Admins :"+e.getMessage());
        }
        return null;
    }



    private Admin createAdminFromString(String account){
        String[] details = account.split("\t");
        return new Admin(details[1],details[2]);
    }
}
