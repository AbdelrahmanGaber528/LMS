package com.librarysystem.dao;

import com.librarysystem.models.Account;
import com.librarysystem.models.Librarian;
import com.librarysystem.util.ColumnName;
import com.librarysystem.util.LMSFileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public  class LibrarianDAO {

    LMSFileManager librarianFileManager = new LMSFileManager("src\\main\\docs\\Librarian.txt");
    AccountDAO librarianAccount = new AccountDAO();


    public void createLibrarianAccount(Librarian librarian){
        try{
            librarianFileManager.insertRow(createLibrarianMap(librarian));
            librarianAccount.addNewAccount(createLibrarianAccount(createLibrarianMap(librarian)));
        }catch (IOException e ){
            System.err.println("Error in add librarian account with admin :" + e.getMessage());
        }
    }

    public void updateLibrarianAccount(Librarian librarian){
        List<Librarian> allLibrarians = getAllLibrarians();
        for(Librarian librarian1 : allLibrarians)
            if(librarian1.getLibrarianId().equals(librarian.getLibrarianId())) {
                librarianFileManager.updateRow(createLibrarianMap(librarian1));
                librarianAccount.updateAccount(createLibrarianAccount(createLibrarianMap(librarian1)));
            }
    }

    public void deleteLibrarianAccount(Librarian librarian){
        List<Librarian> librarians = getAllLibrarians();
        for(Librarian lib : librarians)
            if(lib.getLibrarianId().equals(librarian.getLibrarianId())) {
                librarianFileManager.deleteRow(createLibrarianMap(lib));
                librarianAccount.deleteAccount(createLibrarianAccount(createLibrarianMap(lib)));
            }
    }

    public List<Librarian> getAllLibrarians(){
        try{
            List<String> accounts = librarianFileManager.getAllRows();
            List<Librarian> librarians = new ArrayList<>();
            for(String account : accounts){
                librarians.add(createLibrarianFromString(account));
            }
            return librarians;
        }catch(IOException e){
            System.err.println("Error in getAll librarians :"+e.getMessage());
        }
        return null;
    }

    private Account createLibrarianAccount(Map<ColumnName , String> librarian){
        return new Account(librarian.get(ColumnName.LIBRARIAN_ACCOUNT_ID),librarian.get(ColumnName.USER_NAME),librarian.get(ColumnName.PASSWORD),librarian.get(ColumnName.ROLE));
    }
    private Map<ColumnName,String> createLibrarianMap(Librarian librarian){
        Map<ColumnName ,String> librarianMap = new TreeMap<>();
        librarianMap.put(ColumnName.PATRON_ACCOUNT_ID,librarian.getLibrarianId());
        librarianMap.put(ColumnName.USER_NAME,librarian.getAccount().getUserName());
        librarianMap.put(ColumnName.PASSWORD,librarian.getAccount().getPassword());
        librarianMap.put(ColumnName.CONTACT,librarian.getContact());
        librarianMap.put(ColumnName.PREFERENCES,librarian.getPreferences());
        librarianMap.put(ColumnName.IS_ACTIVE,librarian.getAccount().isActive());

        return librarianMap;
    }
    private Librarian createLibrarianFromString(String account){
        String[] details = account.split("\t");
        return new Librarian(details[1],details[2]);
    }

}
