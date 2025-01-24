package com.lms.service.Admin;

import com.lms.dao.Account.AccountDAO;
import com.lms.dao.Librarian.LibrarianDAO;
import com.lms.dao.Patron.PatronDAO;
import com.lms.models.Account;
import com.lms.models.Librarian.Librarian;
import com.lms.models.Patron.Patron;

public class AdminDashboardService {

    public AdminDashboardService(){}

    public String getNumberOfAllAccounts(){
        int count = 0;
        for(Account _ : new AccountDAO().getAllAccounts())
            count++;
        return String.valueOf(count);
    }

    public String getNumberOPatronAccounts(){
        int count = 0;
        for(Patron _ : new PatronDAO().getAllPatrons())
            count++;
        return String.valueOf(count);
    }

    public String getNumberOLibrarianAccounts(){
        int count = 0;
        for(Librarian _ : new LibrarianDAO().getAllLibrarians())
            count++;
        return String.valueOf(count);
    }



}
