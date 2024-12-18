package com.librarysystem.service;

import com.librarysystem.dao.LibrarianDAO;
import com.librarysystem.models.Librarian;

import java.util.List;

public class LibrarianService implements UserActions{

    private final LibrarianDAO librarianDAO;

    public LibrarianService(){
        librarianDAO = new LibrarianDAO();
    }

    private boolean isFound(String id){
        List<Librarian> librarians = librarianDAO.getAllLibrarians();
        for(Librarian librarian1 : librarians){
            if(librarian1.getLibrarianId().equalsIgnoreCase(id))
                return true;
        }
        return false;
    }

    @Override
    public void updateContact(String id, String newContact) {
        if(isFound(id)){
            Librarian librarian = getLibrarianById(id);
            librarian.setContact(newContact);
            librarianDAO.updateLibrarianAccount(librarian);
        }
    }

    @Override
    public void updatePreferences(String id, String newPreferences) {
        if(isFound(id)){
            Librarian librarian = getLibrarianById(id);
            librarian.setPreferences(newPreferences);
            librarianDAO.updateLibrarianAccount(librarian);
        }
    }

    private Librarian getLibrarianById(String id ){
        List<Librarian> librarians = librarianDAO.getAllLibrarians();
        for(Librarian librarian1 : librarians){
            if(librarian1.getLibrarianId().equalsIgnoreCase(id))
                return librarian1;
        }
        return null;
    }
}
