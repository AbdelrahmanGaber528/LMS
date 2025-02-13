package com.lms.service;

import com.lms.models.Account;
import com.lms.service.Account.AccountService;

public class LoginService {
        
    private final AccountService accountService;

    public LoginService(){
        accountService = new AccountService();
    }

    public  Account login(String userName , String password){

        for(Account account : accountService.getAllUsers()){
            if(account.getUserName().equalsIgnoreCase(userName) && account.getPassword().equalsIgnoreCase(password))
                return account;
        }
        return null;

    }

    public  String getRole(String accountID) {
        Account account = getAccount(accountID);
        if (account != null) {
            return account.getRole();
        }
        return null;
    }

    private  Account getAccount(String id ){

        for(Account account : accountService.getAllUsers())
            if(account.getAccountID().equalsIgnoreCase(id))
                return account;
        return null;

    }

}
