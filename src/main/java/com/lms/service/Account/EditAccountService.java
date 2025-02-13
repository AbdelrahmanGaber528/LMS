package com.lms.service.Account;

import com.lms.models.Account;

public class EditAccountService {

    public static void editAccount(Account account){
        Account oldAccount = AccountService.getAccount(account.getAccountID());
        if(oldAccount == null){
            System.err.println("This Book Not Found.");
        }else{
            AccountService.updateAccount(account);
        }
    }
}
