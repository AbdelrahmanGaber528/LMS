package com.lms.controller.Admin;

import com.lms.models.Model;
import com.lms.util.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    public BorderPane admin_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observable , oldVal , newVal)->{
            switch (newVal){
                case AdminMenuOptions.BOOKS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getBooksView());
                case AdminMenuOptions.ACCOUNTS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
                case AdminMenuOptions.PROFILE-> admin_parent.setCenter(Model.getInstance().getViewFactory().getProfileView());
                default -> admin_parent.setCenter(Model.getInstance().getViewFactory().getDashBoardView());
            }
        } );
    }

}
