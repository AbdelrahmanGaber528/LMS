package com.lms.service.Admin;

import com.lms.dao.Admin.AdminDAO;
import com.lms.models.Admin.Admin;
import com.lms.service.UpdateUserInfo;

public class AdminService implements UpdateUserInfo {

    private final static AdminDAO adminDAO = new AdminDAO();

    public void updateContact(String adminId , String newContact) {

    }

    @Override
    public void updatePreferences(String id, String newPreferences) {

    }

    public static Admin getById(String id ){
        for(Admin admin : adminDAO.getAllAdmins()){
            if(admin.getAdminId().equalsIgnoreCase(id))
                return admin;
        }
        return null;
    }


}
