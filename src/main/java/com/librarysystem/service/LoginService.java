package com.librarysystem.service;

import com.librarysystem.dao.AccountDAO;
import com.librarysystem.models.Account;
import com.librarysystem.models.User;

import java.util.List;

public class LoginService {

    private final AccountDAO accountDAO ;

    public LoginService(){
        accountDAO = new AccountDAO();
    }

    public String getRole(String userId){
        Account account = accountDAO.getById(userId);
        return account.getRole();
    }

    public boolean login(String userName , String password){
        List<Account> accounts  = accountDAO.getAllAccounts();
        for(Account account : accounts){
            if(account.getUserName().equalsIgnoreCase(userName) && account.getPassword().equalsIgnoreCase(password))
                return true;
        }
        return false;
    }

    public void register(User user){
        try {
            System.out.println("Register user: " + user.toString());

            if (user.getAccount() == null) {
                throw new IllegalArgumentException("User or Account object is null.");
            }
            // Check if the account already exists by ID
            if (!isFound(user.getAccount().getAccountID())) {
                System.out.println("User not found. Proceeding with registration.");
                accountDAO.addNewAccount(user.getAccount());
                System.out.println("Registration successful for user: " + user);
            } else {
                System.err.println("Account already exists for ID: " + user.getAccount().getAccountID());
            }
        } catch (Exception e) {
            System.err.println("Error in registering user: " + e.getMessage());
        }
    }

    public void activateAccount(String userId) {
        Account account = accountDAO.getById(userId);
        if (account != null) {
            account.setIsActive(true);
            accountDAO.updateAccount(account);
            System.out.println("Account activated for user: " + userId);
        } else {
            System.err.println("Account not found for user ID: " + userId);
        }
    }

    public void deactivateAccount(String userId) {
        Account account = accountDAO.getById(userId);
        if (account != null) {
            account.setIsActive(false);
            accountDAO.updateAccount(account);
            System.out.println("Account deactivated for user: " + userId);
        } else {
            System.err.println("Account not found for user ID: " + userId);
        }
    }

    public void resetPassword(String userId, String newPassword) {
        Account account = accountDAO.getById(userId);
        if (account != null) {
            account.setPassword(newPassword);
            accountDAO.updateAccount(account);
            System.out.println("Password reset successfully for user ID: " + userId);
        } else {
            System.err.println("Account not found for user ID: " + userId);
        }
    }

    private boolean isFound(String userId){
        return accountDAO.getById(userId) != null;
    }

}
