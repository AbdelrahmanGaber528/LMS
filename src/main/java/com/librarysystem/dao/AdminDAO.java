package com.librarysystem.dao;

import com.librarysystem.models.Account;
import com.librarysystem.models.Admin;
import com.librarysystem.util.ColumnName;
import com.librarysystem.util.LMSFileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AdminDAO {
    private final LMSFileManager adminFileManager ;
    private final AccountDAO adminAccount;

    public AdminDAO(){
        adminAccount = new AccountDAO();
        adminFileManager = new LMSFileManager("src\\main\\docs\\Admin.txt");
    }

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

    public void addNewAdmin(Admin admin){
        try{
            adminFileManager.insertRow(createAdminMap(admin));
            adminAccount.addNewAccount(createAccountAdmin(admin));
        }catch (IOException e){
            System.err.println("Error add new admin :"+e.getMessage());
        }
    }

    public void deleteAdmin(Admin admin){
        adminFileManager.deleteRow(createAdminMap(admin));
        adminAccount.deleteAccount(createAccountAdmin(admin));
    }

    public void updateAdmin(Admin admin){
        adminFileManager.updateRow(createAdminMap(admin));
        adminAccount.updateAccount(createAccountAdmin(admin));
    }


    private Account createAccountAdmin(Admin admin){
        return new Account(admin.getAccount().getUserName(),admin.getAccount().getPassword(),"Admin");
    }
    private Map<ColumnName,String> createAdminMap(Admin admin){
        Map<ColumnName,String> adminMap = new TreeMap<>();
        adminMap.put(ColumnName.ADMIN_Account_ID,admin.getAdminId());
        adminMap.put(ColumnName.USER_NAME,admin.getAccount().getUserName());
        adminMap.put(ColumnName.PASSWORD,admin.getAccount().getPassword());
        adminMap.put(ColumnName.CONTACT,admin.getContact());
        adminMap.put(ColumnName.PREFERENCES,admin.getPreferences());
        adminMap.put(ColumnName.IS_ACTIVE,admin.getAccount().isActive());

        return adminMap;
    }
    private Admin createAdminFromString(String account){
        String[] details = account.split("\t");
        return new Admin(details[1],details[2]);
    }
}
