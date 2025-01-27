package com.lms.dao;

import com.lms.dao.Patron.PatronDAO;
import com.lms.models.Patron.Patron;
import org.junit.jupiter.api.Test;


import java.util.List;

public class PatronDAOTest {
    @Test
    public void testInsertMultiplePatrons() {
        PatronDAO patronDAO = new PatronDAO();

        // Create and add five patron accounts with unique details
        Patron patron1 = new Patron("Frank", "password1");
        patron1.setContact("frank@example.com");
        patron1.setPreferences("Fantasy Books");
        patronDAO.addNewPatron(patron1);

        Patron patron2 = new Patron("Grace", "password2");
        patron2.setContact("grace@example.com");
        patron2.setPreferences("Romance Novels");
        patronDAO.addNewPatron(patron2);

        Patron patron3 = new Patron("Hank", "password3");
        patron3.setContact("hank@example.com");
        patron3.setPreferences("Adventure");
        patronDAO.addNewPatron(patron3);

        Patron patron4 = new Patron("Ivy", "password4");
        patron4.setContact("ivy@example.com");
        patron4.setPreferences("Self-Help");
        patronDAO.addNewPatron(patron4);

        Patron patron5 = new Patron("Jack", "password5");
        patron5.setContact("jack@example.com");
        patron5.setPreferences("Science Books");
        patronDAO.addNewPatron(patron5);

        // Print all patrons added
        System.out.println("Patrons successfully added:");
        patronDAO.getAllPatrons().forEach(patron -> {
            System.out.println("ID: " + patron.getPatronId() + ", Name: " + patron.getAccount().getUserName() + ", Contact: " + patron.getContact() + ", Preferences: " + patron.getPreferences());
        });
    }
    @Test
    public void testDeletePatronById() {
        PatronDAO patronDAO = new PatronDAO();
        String patronIdToDelete = "38"; // Example ID to delete

        List<Patron> patrons = patronDAO.getAllPatrons();
        for(Patron patron : patrons){
            if(patron.getPatronId().equalsIgnoreCase(patronIdToDelete))
                patronDAO.deletePatronAccount(patron);
        }
    }
    @Test
    public void clearPatrons() {
    PatronDAO patronDAO = new PatronDAO();
    patronDAO.clearPatrons();
    }
    @Test
    public void testUpdate(){
        PatronDAO patronDAO = new PatronDAO();
        Patron patron = new Patron("Mohammed","1234");
        patron.setContact("01095151496");
        patron.setPreferences("History");
        patron.setPatronId("3");
        patronDAO.updatePatronAccount(patron);
    }
}
