package com.lms.dao;

import com.lms.dao.Admin.AdminDAO;
import com.lms.models.Admin.Admin;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AdminDAOTest {
    @Test
    public void testInsertMultipleAdmins() {
        AdminDAO adminDAO = new AdminDAO();

        // Create and add five admin accounts with unique details
        Admin admin1 = new Admin("Abdelrahman", "00000");
        admin1.setContact("alice@example.com");
        admin1.setPreferences("Tech Books");
        adminDAO.addNewAdmin(admin1);

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
