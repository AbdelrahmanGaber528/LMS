package com.librarysystem.service;

import com.librarysystem.dao.LibrarianDAO;
import com.librarysystem.models.Librarian;

import java.util.List;

public class LibrarianService{

    private final LibrarianDAO librarianDAO = new LibrarianDAO();

    public void updateContact(Librarian librarian) {
            if(isFound(librarian))
                librarianDAO.updateLibrarianAccount(librarian);
    }

    public void updatePreferences(Librarian librarian) {
        if(isFound(librarian))
            librarianDAO.updateLibrarianAccount(librarian);
    }

    public boolean isFound(Librarian librarian){
        List<Librarian> librarians = librarianDAO.getAllLibrarians();
        for(Librarian librarian1 : librarians){
            if(librarian1.getLibrarianId().equalsIgnoreCase(librarian.getLibrarianId()))
                return true;
        }
        return false;
    }

}
