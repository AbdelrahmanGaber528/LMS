package com.librarysystem.service;

import org.junit.Test;

public class AccountServiceTest {
    @Test
    public void testGetROle(){
        AccountService accountService = new AccountService();
        System.out.println(accountService.getRole("2"));
    }

    @Test
    public void testLogin(){
        AccountService accountService = new AccountService();
        System.out.println(accountService.login("Frank","password1"));
    }

    @Test
    public void testPass(){
        AccountService accountService = new AccountService();
        accountService.resetPassword("34","FUCK**");
    }
    @Test
    public void testActive(){
        AccountService accountService = new AccountService();
        accountService.deactivateAccount("33");
        accountService.activateAccount("34");
    }
}
