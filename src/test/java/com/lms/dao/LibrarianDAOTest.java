package com.lms.dao;

import com.lms.dao.Librarian.LibrarianDAO;
import com.lms.models.Librarian.Librarian;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LibrarianDAOTest {
    @Test
    public void testInsertMultipleLibrarians() {
        LibrarianDAO librarianDAO = new LibrarianDAO();

        // Create and add five librarian accounts with unique details
        Librarian librarian1 = new Librarian("Laura", "password1");
        librarian1.setContact("laura@example.com");
        librarian1.setPreferences("Digital Resources");
        librarianDAO.addLibrarianAccount(librarian1);

        Librarian librarian2 = new Librarian("Mark", "password2");
        librarian2.setContact("mark@example.com");
        librarian2.setPreferences("Children's Books");
        librarianDAO.addLibrarianAccount(librarian2);

        Librarian librarian3 = new Librarian("Nancy", "password3");
        librarian3.setContact("nancy@example.com");
        librarian3.setPreferences("Rare Books");
        librarianDAO.addLibrarianAccount(librarian3);

        Librarian librarian4 = new Librarian("Oscar", "password4");
        librarian4.setContact("oscar@example.com");
        librarian4.setPreferences("Science Journals");
        librarianDAO.addLibrarianAccount(librarian4);

        Librarian librarian5 = new Librarian("Paul", "password5");
        librarian5.setContact("paul@example.com");
        librarian5.setPreferences("Music Collections");
        librarianDAO.addLibrarianAccount(librarian5);

        // Print all librarians added
        System.out.println("Librarians successfully added:");
        librarianDAO.getAllLibrarians().forEach(librarian -> {
            System.out.println("ID: " + librarian.getLibrarianId() + ", Name: " + librarian.getAccount().getUserName() + ", Contact: " + librarian.getContact() + ", Preferences: " + librarian.getPreferences());
        });
    }
    @Test
    public void testDelete(){
        LibrarianDAO librarianDAO = new LibrarianDAO();
        librarianDAO.clearLibrarians();
    }

    @Test
    public void testDeleteByID(){
        LibrarianDAO librarianDAO = new LibrarianDAO();
        List<Librarian> librarians = librarianDAO.getAllLibrarians();
        for(Librarian librarian : librarians){
            if(librarian.getLibrarianId().equalsIgnoreCase("52"))
                librarianDAO.deleteLibrarianAccount(librarian);
        }
    }
    @Test
    public void testUpdate(){
        LibrarianDAO librarianDAO = new LibrarianDAO();
        Librarian librarian = new Librarian("Abdelrahman","2020");
        librarian.setLibrarianId("4");
        librarian.setContact("01215");
        librarian.setPreferences("Kill");
        librarianDAO.updateLibrarianAccount(librarian);
    }
}
