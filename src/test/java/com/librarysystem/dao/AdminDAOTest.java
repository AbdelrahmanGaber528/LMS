package com.librarysystem.dao;

import com.librarysystem.models.Admin;
import com.librarysystem.models.Patron;
import org.junit.Test;

import java.util.List;

public class AdminDAOTest {
    @Test
    public void testInsertMultipleAdmins() {
        AdminDAO adminDAO = new AdminDAO();

        // Create and add five admin accounts with unique details
        Admin admin1 = new Admin("Alice", "password1");
        admin1.setContact("alice@example.com");
        admin1.setPreferences("Tech Books");
        adminDAO.addNewAdmin(admin1);

        Admin admin2 = new Admin("Bob", "password2");
        admin2.setContact("bob@example.com");
        admin2.setPreferences("Science Fiction");
        adminDAO.addNewAdmin(admin2);

        Admin admin3 = new Admin("Charlie", "password3");
        admin3.setContact("charlie@example.com");
        admin3.setPreferences("History");
        adminDAO.addNewAdmin(admin3);

        Admin admin4 = new Admin("Diana", "password4");
        admin4.setContact("diana@example.com");
        admin4.setPreferences("Biographies");
        adminDAO.addNewAdmin(admin4);

        Admin admin5 = new Admin("Eve", "password5");
        admin5.setContact("eve@example.com");
        admin5.setPreferences("Mystery Novels");
        adminDAO.addNewAdmin(admin5);

        // Print all admins added
        System.out.println("Admins successfully added:");
        adminDAO.getAllAdmins().forEach(admin -> {
            System.out.println("ID: " + admin.getAdminId() + ", Name: " + admin.getAccount().getUserName() + ", Contact: " + admin.getContact() + ", Preferences: " + admin.getPreferences());
        });
    }
    @Test
    public void tstDelete(){
        AdminDAO adminDAO = new AdminDAO();
        List<Admin> allAdmins = adminDAO.getAllAdmins();
        for(Admin admin:allAdmins){
            if(admin.getAdminId().equalsIgnoreCase("40")){
                adminDAO.deleteAdmin(admin);
            }
        }
    }

    @Test
    public void testDeleteAdmin() {
        AdminDAO adminDAO = new AdminDAO();
//        Admin admin = new Admin("Ahomi", "22");
//        admin.setContact("0102");
//        admin.setPreferences("history");
////
//        adminDAO.addNewAdmin(admin); // Add admin
//        List<Admin> adminsBeforeDeletion = adminDAO.getAllAdmins();
//        System.out.println("Admins before deletion: " + adminsBeforeDeletion.toString());
//////
//        List<Admin> admins = adminDAO.getAllAdmins();
//        for(Admin admin1 : admins){
//            if(admin1.getAdminId().equalsIgnoreCase("17"))
//                adminDAO.deleteAdmin(admin1);
//        }
        adminDAO.clearAdmins();
//        List<Admin> adminsAfterDeletion = adminDAO.getAllAdmins();
//        System.out.println("Admins after deletion: " + adminsAfterDeletion.toString());

//        assert adminsAfterDeletion.stream().noneMatch(a -> a.getAdminId().equals(admin.getAdminId()));
    }
    @Test
    public void testDeleteRole(){
        AdminDAO adminDAO = new AdminDAO();
        adminDAO.clearAdmins();
    }
}
