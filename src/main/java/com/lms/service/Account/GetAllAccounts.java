package com.lms.service.Account;

import com.lms.models.Account;

import java.util.List;

public class GetAllAccounts {

    public static List<Account> getAllAccounts(){
        return AccountService.getAllUsers();
    }

}
