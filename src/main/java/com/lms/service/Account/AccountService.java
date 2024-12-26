package com.lms.service.Account;

import com.lms.dao.Account.AccountDAO;
import com.lms.models.Account;

import java.util.List;

public class AccountService {

    private final AccountDAO accountDAO ;

    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public List<Account> getAllUsers(){
        return accountDAO.getAllAccounts();
    }

    public void deleteAccount(String id ){
        accountDAO.deleteAccount(getAccount(id));
    }

    private  Account getAccount(String id ){
        for(Account account : accountDAO.getAllAccounts())
            if(account.getAccountID().equalsIgnoreCase(id))
                return account;
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

    public void updateAccount(Account account){
        accountDAO.updateAccount(account);
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
