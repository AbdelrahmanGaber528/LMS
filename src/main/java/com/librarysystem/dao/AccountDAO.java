package com.librarysystem.dao;

import com.librarysystem.models.Account;
import com.librarysystem.util.ColumnName;
import com.librarysystem.util.LMSFileManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AccountDAO {

    private final LMSFileManager accountFileManager = new LMSFileManager("src\\main\\docs\\Accounts.txt");

    private static int idCounter = 0;

    public AccountDAO() {
        File file = new File("src\\main\\docs\\idCounter.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                idCounter = Integer.parseInt(reader.readLine().trim());
            } catch (IOException e) {
                System.err.println("Can't read the id from file: " + e.getMessage());
            }
        }
    }

    public void addNewAccount(Account account){
        try{
            int newId = generateId();
            account.setId(String.valueOf(newId)); // Set the generated ID
            accountFileManager.insertRow(createAccountMap(account));
        }catch(IOException e){
            System.err.println("Problem in adding account :"+e.getMessage());
        }
    }

    public void updateAccount(Account account){
        accountFileManager.updateRow(createAccountMap(account));
    }

    public boolean authenticate(String userName, String password){
        List<Account> user = getValidAccounts(userName);
        if(user.isEmpty()) return false;
        for(Account account : user)
            if(account.getPassword().equalsIgnoreCase(password))
                return true;
        return false;
    } // to check the login information

    public void deleteAccount(Account account){
        accountFileManager.deleteRow(createAccountMap(account));
    }

    Account getValidateAccount(String id ){
        try {
            // Retrieve all rows from the file
            List<String> allAccounts = accountFileManager.getAllRows();
            for (String a : allAccounts) {
                String[] details = a.split("\t");
                // Ensure data has the expected format
                if (details.length >=5 && details[0].trim().equalsIgnoreCase(id.trim())) {
                    return createAccount(createAccountMap(a));
                }
            }
        } catch (IOException e) {
            System.err.println("Error in getValidAccount method: " + e.getMessage());
        }
        return null;
    }

    List<Account> getValidAccounts(String userName){
        List<Account> users = new ArrayList<>();
        try {
            // Retrieve all rows from the file
            List<String> allAccounts = accountFileManager.getAllRows();
            for (String a : allAccounts) {
                String[] details = a.split("\t");
                // Ensure data has the expected format
                if (details.length >=5 && details[1].trim().equalsIgnoreCase(userName.trim())) {
                    users.add(createAccount(createAccountMap(a)));
                }
            }
        } catch (IOException e) {
            System.err.println("Error in getValidAccounts method: " + e.getMessage());
        }
        return users;
    }

    private Account createAccount(Map<ColumnName, String> user) {
        String id = user.get(ColumnName.USER_ID); // Parse ID
        String userName = user.get(ColumnName.USER_NAME);
        String password = user.get(ColumnName.PASSWORD);
        String role = user.get(ColumnName.ROLE);
        return new Account(id, userName, password, role);
    }

    private Map<ColumnName,String> createAccountMap(String user){
        String[] details = user.split("\t");
        Map<ColumnName,String> account = new TreeMap<>();
        account.put(ColumnName.USER_ID,details[0]);
        account.put(ColumnName.USER_NAME,details[1]);
        account.put(ColumnName.PASSWORD,details[2]);
        account.put(ColumnName.ROLE,details[3]);
        account.put(ColumnName.IS_ACTIVE, details[4]);

        return account;
    } // create map from string , |^|
    /// we will use this method in createAccount
    private Map<ColumnName ,String> createAccountMap(Account account){
        Map<ColumnName ,String > accountMap = new TreeMap<>();

        accountMap.put(ColumnName.USER_ID,account.getAccountID());
        accountMap.put(ColumnName.IS_ACTIVE,account.isActive());
        accountMap.put(ColumnName.USER_NAME,account.getUserName());
        accountMap.put(ColumnName.PASSWORD,account.getPassword());
        accountMap.put(ColumnName.ROLE,account.getRole());

        return accountMap;
    } // create Map from account object

    public  int generateId() {
        idCounter++;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\docs\\idCounter.txt"))) {
            writer.write(String.valueOf(idCounter));
        } catch (IOException e) {
            System.err.println("Can't write new id to file: " + e.getMessage());
        }
        return idCounter;
    }

}
