package com.librarysystem.dao;

import com.librarysystem.models.Account;
import com.librarysystem.models.Patron;
import com.librarysystem.util.ColumnName;
import com.librarysystem.util.LMSFileManager;

import java.io.IOException;
import java.util.*;

public class PatronDAO {

     private final LMSFileManager patronFileManager ;
     private final AccountDAO patronAccount;

    public PatronDAO(){
        patronFileManager = new LMSFileManager("src\\main\\docs\\Patron.txt");
        patronAccount = new AccountDAO();
    }
    public void createPatronAccount (Patron patron){
        try {
            patronFileManager.insertRow(createPatronMap(patron));
        } catch (IOException e) {
            System.err.println("Error in add librarian account with admin :" + e.getMessage());
        }
    }

    public void deletePatronAccount(Patron patron) {
        patronFileManager.deleteRow(createPatronMap(patron));
        patronAccount.deleteAccount(createLibrarianAccount(createPatronMap(patron)));
    }

    public void updatePatronAccount (Patron patron){
    }

    public List<Patron> getAllPatrons(){
       try{
           List<String> accounts = patronFileManager.getAllRows();
           List<Patron> patrons = new ArrayList<>();
           for(String account : accounts){
               patrons.add(createPatronFromString(account));
           }
           return patrons;
       }catch(IOException e){
           System.err.println("Error in getPatrons :"+e.getMessage());
       }
       return null;
    }

    private Map<ColumnName, String> createPatronMap (Patron patron){
        Map<ColumnName, String> patronMap = new TreeMap<>();
        patronMap.put(ColumnName.PATRON_ACCOUNT_ID, patron.getPatronId());
        patronMap.put(ColumnName.USER_NAME, patron.getAccount().getUserName());
        patronMap.put(ColumnName.PASSWORD, patron.getAccount().getPassword());
        patronMap.put(ColumnName.CONTACT, patron.getContact());
        patronMap.put(ColumnName.PREFERENCES, patron.getPreferences());
        patronMap.put(ColumnName.IS_ACTIVE, patron.getAccount().isActive());

        return patronMap;
    }
    private Account createLibrarianAccount(Map<ColumnName , String> patron){
        return new Account(patron.get(ColumnName.LIBRARIAN_ACCOUNT_ID),patron.get(ColumnName.USER_NAME),patron.get(ColumnName.PASSWORD),patron.get(ColumnName.ROLE));
    }
    private Patron createPatronFromString(String account){
        String[] details = account.split("\t");
        return new Patron(details[1],details[2]);
    }
}
