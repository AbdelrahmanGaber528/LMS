package com.librarysystem.service;

import com.librarysystem.dao.AccountDAO;
import com.librarysystem.models.Account;

import java.util.List;

public class AccountService {

    private final AccountDAO accountDAO ;

    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public String getRole(String userId){
        Account account = accountDAO.getById(userId);
        return account.getRole();
    }

    public Account login(String userName , String password){
        List<Account> accounts  = accountDAO.getAllAccounts();
        for(Account account : accounts){
            if(account.getUserName().equalsIgnoreCase(userName) && account.getPassword().equalsIgnoreCase(password))
                return account;
        }
        return null;
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

}
