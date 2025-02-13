package com.lms.dao.Patron;

import com.lms.dao.Account.AccountDAO;
import com.lms.models.Account;
import com.lms.models.Patron.Patron;
import com.lms.util.ColumnName;
import com.lms.util.LMSFileManager;

import java.io.IOException;
import java.util.*;

public class PatronDAO {

     private final LMSFileManager patronFileManager ;
     private final AccountDAO patronAccount;

    public PatronDAO(){
        patronFileManager = new LMSFileManager("src/main/docs/Patron.txt");
        patronAccount = new AccountDAO();
    }

    public void addNewPatron(Patron patron){
        try {
            Account account = createAccountPatron(patron);
            patronAccount.addNewAccount(account);
            String id = account.getAccountID(); // Generate a single ID
            account.setId(id); // Use the same ID for the Account
            patron.setPatronId(id);
            patronFileManager.insertRow(createPatronMap(patron));
        } catch (IOException e) {
            System.err.println("Error in adding patron account  :" + e.getMessage());
        }
    }

    public void deletePatronAccount(Patron patron) {
        patronFileManager.deleteRow(createPatronMap(patron));
        patronAccount.deleteAccount(createAccountPatron(patron));
    }

    public void updatePatronAccount (Patron patron){
        patronFileManager.updateRow(createPatronMap(patron));
        patronAccount.updateAccount(createAccountPatron(patron));
    }

    public List<Patron> getAllPatrons(){
           List<Patron> patrons = new ArrayList<>();
       try{
           List<String> accounts = patronFileManager.getAllRows();
           for (int i = 1; i < accounts.size(); i++) { // Start from index 1 to skip the first element
               String account = accounts.get(i);
               Patron patron = createPatronFromString(account);
               patrons.add(patron);
           }

       }catch(IOException e){
           System.err.println("Error in getPatrons :"+e.getMessage());
       }
        return patrons;
    }

    public void clearPatrons(){
        try{
            patronFileManager.clearFile();
            patronAccount.clearAccounts("Patron");
        }catch(IOException e){
            System.err.println("Error in deleting patron accounts :"+e.getMessage());
        }
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
    private Account createAccountPatron(Patron patron){
        Account account = new Account(patron.getAccount().getUserName(),patron.getAccount().getPassword(),"Patron");
        account.setId(patron.getPatronId());
        return account;
    }
    private Patron createPatronFromString(String account){
        String[] details = account.split("\t");
        Patron patron = new Patron(details[1],details[2]);
        patron.setPatronId(details[0]);
        patron.setContact(details[3]);
        patron.setPreferences(details[4]);

        return patron;
    }
}
