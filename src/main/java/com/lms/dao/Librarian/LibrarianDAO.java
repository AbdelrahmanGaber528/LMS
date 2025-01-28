package com.lms.dao.Librarian;

import com.lms.dao.Account.AccountDAO;
import com.lms.models.Account;
import com.lms.models.Librarian.Librarian;
import com.lms.util.ColumnName;
import com.lms.util.LMSFileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public  class LibrarianDAO {

   private final LMSFileManager librarianFileManager ;
   private final AccountDAO librarianAccount;

   public LibrarianDAO(){
       librarianFileManager = new LMSFileManager("src/main/docs/Librarian.txt");
       librarianAccount =   new AccountDAO();
   }

    public void addLibrarianAccount(Librarian librarian){
        try {
            Account account = createAccountLibrarian(librarian);
            librarianAccount.addNewAccount(account);
            String id = account.getAccountID(); // Generate a single ID
            account.setId(id); // Use the same ID for the Account
            librarian.setLibrarianId(id);
            librarianFileManager.insertRow(createLibrarianMap(librarian));
        } catch (IOException e) {
            System.err.println("Error in adding librarian account  :" + e.getMessage());
        }
    }

    public void updateLibrarianAccount(Librarian librarian){
        librarianFileManager.updateRow(createLibrarianMap(librarian));
        librarianAccount.updateAccount(createAccountLibrarian(librarian));
    }

    public void deleteLibrarianAccount(Librarian librarian){
        librarianFileManager.deleteRow(createLibrarianMap(librarian));
        librarianAccount.deleteAccount(createAccountLibrarian(librarian));
    }

    public List<Librarian> getAllLibrarians(){
            List<Librarian> librarians = new ArrayList<>();
        try{
            List<String> accounts = librarianFileManager.getAllRows();
            for (int i = 1; i < accounts.size(); i++) { // Start from index 1 to skip the first element
                String account = accounts.get(i);
                Librarian librarian = createLibrarianFromString(account);
                librarians.add(librarian);
            }
        }catch(IOException e){
            System.err.println("Error in getAll librarians :"+e.getMessage());
        }
        return librarians;
    }

    public void clearLibrarians(){
        try{
            librarianFileManager.clearFile();
            librarianAccount.clearAccounts("librarian");
        }catch(IOException e){
            System.err.println("Error in deleting librarian accounts :"+e.getMessage());
        }
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

    private Account createAccountLibrarian(Librarian librarian){
       Account account = new Account(librarian.getAccount().getUserName(),librarian.getAccount().getPassword(),"Librarian");
       account.setId(librarian.getLibrarianId());
       return account;
    }

    private Librarian createLibrarianFromString(String account){
        String[] details = account.split("\t");
        Librarian librarian = new Librarian(details[1],details[2]);
        librarian.setLibrarianId(details[0]);
        librarian.setContact(details[3]);
        librarian.setPreferences(details[4]);

        return librarian;
    }

}
