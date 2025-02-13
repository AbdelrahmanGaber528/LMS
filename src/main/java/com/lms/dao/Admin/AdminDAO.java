package com.lms.dao.Admin;

import com.lms.dao.Account.AccountDAO;
import com.lms.models.Account;
import com.lms.models.Admin.Admin;
import com.lms.util.ColumnName;
import com.lms.util.LMSFileManager;

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
        adminFileManager = new LMSFileManager("src/main/docs/Admin.txt");
    }

    public List<Admin> getAllAdmins()   {
            List<Admin> admins = new ArrayList<>();
        try{
            List<String> accounts = adminFileManager.getAllRows();
            for (int i = 1; i < accounts.size(); i++) { // Start from index 1 to skip the first element
                String account = accounts.get(i);
                Admin admin = createAdminFromString(account);
                admins.add(admin);
            }

        }catch (IOException e){
            System.err.println("Error in get Admins :"+e.getMessage());
        }
        return admins;
    }

    public void addNewAdmin(Admin admin){
        try{
            Account account = createAccountAdmin(admin);
            adminAccount.addNewAccount(account);
            String id = account.getAccountID();
            account.setId(id);
            admin.setAdminId(id);
            adminFileManager.insertRow(createAdminMap(admin));
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

    public void clearAdmins(){
        try{
            adminFileManager.clearFile();
            adminAccount.clearAccounts("Admin");
        }catch(IOException e){
            System.err.println("Error in clearing admin file :"+e.getMessage());
        }
    }

    private Account createAccountAdmin(Admin admin){
         Account account = new Account(admin.getAccount().getUserName(),admin.getAccount().getPassword(),"Admin");
         account.setId(admin.getAdminId());
         return account;
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
        Admin admin = new Admin(details[1],details[2]);
        admin.setAdminId(details[0]);
        admin.setContact(details[3]);
        admin.setPreferences(details[4]);

        return admin;
    }
}
