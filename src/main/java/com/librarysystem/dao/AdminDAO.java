package com.librarysystem.dao;

import com.librarysystem.models.Account;
import com.librarysystem.models.Librarian;
import com.librarysystem.models.Patron;
import com.librarysystem.util.ColumnName;
import com.librarysystem.util.LMSFileManager;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AdminDAO {
    LMSFileManager fileManager = new LMSFileManager("src\\main\\docs\\Admin.txt");
    AccountDAO adminAccount = new AccountDAO();

    public AdminDAO(){}

    public void createLibrarianAccount(Librarian librarian){

    }

    public void createPatronAccount(Patron patron){

    }

    public void deletePatronAccount(Patron patron){

    }

    public void deleteLibrarianAccount(Librarian librarian){}

    public void updatePatronAccount(Patron patron){}

    public void updateLibrarianAccount(Librarian librarian){}

    public List<Account> search(){}

    public List<Patron> searchForPatron(String keyword){}

    public List<Librarian> searchForLibrarian(String keyword){}

    public void updateUserName(String userName){}
    public void updatePassword(String password){}

    private Map<ColumnName,String> createPatronMap(Patron patron){

    }
    private Map<ColumnName,String> createLibrarianMap(Librarian librarian){

    }


}
