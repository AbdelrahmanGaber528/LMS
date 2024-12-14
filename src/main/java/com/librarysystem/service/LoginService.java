package com.librarysystem.service;

import com.librarysystem.dao.AccountDAO;
import com.librarysystem.util.LMSFileManager;

public class LoginService {

    private final LMSFileManager fileManager;
    private final AccountDAO accountDAO ;

    public LoginService(){
        fileManager = new LMSFileManager("src\\main\\docs\\Accounts.txt");
        accountDAO = new AccountDAO();
    }
    
}
