package com.librarysystem.service;

import com.librarysystem.models.Patron;
import com.librarysystem.models.User;
import org.junit.Test;

public class LoginServiceTest {
    @Test
    public void testGetROle(){
        LoginService loginService = new LoginService();
        System.out.println(loginService.getRole("2"));
    }

    @Test
    public void testLogin(){
        LoginService loginService = new LoginService();
        System.out.println(loginService.login("Frank","password1"));
    }

    @Test
    public void testRegister(){
//        LoginService loginService = new LoginService();
//        System.out.println(loginService.isFound("2"));
//        AccountDAO accountDAO = new AccountDAO();
//        Account account = accountDAO.getById("2");
//        System.out.println(account.getUserName());
//        AccountDAO accountDAO = new AccountDAO();
//        Account account = new Account("tempUser", "password123", "user", "Patron");
//        accountDAO.addNewAccount(account);
        LoginService loginService = new LoginService();
        User user = new Patron("patronName", "tmpPassword");
        user.getAccount().setId("34");
        loginService.register(user);

    }

    @Test
    public void testPass(){
        LoginService loginService = new LoginService();
        loginService.resetPassword("34","FUCK**");
    }
    @Test
    public void testActive(){
        LoginService loginService = new LoginService();
        loginService.deactivateAccount("33");
        loginService.activateAccount("34");
    }
}
