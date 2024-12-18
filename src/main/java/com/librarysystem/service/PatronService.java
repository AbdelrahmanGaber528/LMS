package com.librarysystem.service;

import com.librarysystem.dao.PatronDAO;
import com.librarysystem.models.Patron;

import java.util.List;

public class PatronService implements UserActions{

    private final PatronDAO patronDAO;

    public PatronService(){
        patronDAO = new PatronDAO();
    }

    @Override
    public void updateContact(String id, String newContact) {
        if(isFound(id)){
            Patron patron = getPatronById(id);
            patron.setContact(newContact);
            patronDAO.updatePatronAccount(patron);
        }
    }

    @Override
    public void updatePreferences(String id, String newPreferences) {
        if(isFound(id)){
            Patron patron = getPatronById(id);
            patron.setPreferences(newPreferences);
            patronDAO.updatePatronAccount(patron);
        }
    }

    private Patron getPatronById(String id ){
        List<Patron> patrons = patronDAO.getAllPatrons();
        for(Patron patron : patrons){
            if(patron.getPatronId().equalsIgnoreCase(id))
               return patron;
        }
        return null;
    }

    private boolean isFound(String id){
        List<Patron> patrons = patronDAO.getAllPatrons();
        for(Patron patron : patrons){
            if(patron.getPatronId().equalsIgnoreCase(id))
                return true;
        }
        return false;
    }
}
