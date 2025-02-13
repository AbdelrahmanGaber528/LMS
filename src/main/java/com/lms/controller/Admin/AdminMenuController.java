package com.lms.controller.Admin;

import com.lms.models.Model;
import com.lms.util.AdminMenuOptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class AdminMenuController  implements Initializable {

    @FXML
    public Text name_of_admin;
    @FXML
    public Button dashboard_id;
    @FXML
    public Button books_id;
    @FXML
    public Button accounts_id;
    @FXML
    public Button profile_id;
    @FXML
    public Button logout_id;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            addListeners();
    }

    private void addListeners(){
        dashboard_id.setOnAction(_ -> onDashboard());
        books_id.setOnAction(_ -> onBooks());
        profile_id.setOnAction(_ -> onProfile());
        accounts_id.setOnAction(_ -> onAccounts());
        logout_id.setOnAction(this::onLogout);
    }

    public void setName_of_admin(String name){
        name_of_admin.setText(name);
    }
    private void onBooks(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.BOOKS);
    }

    private void onDashboard(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.DASHBOARD);
    }

    private void onProfile(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.PROFILE);
    }

    private void onAccounts(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.ACCOUNTS);
    }

    public  void onLogout(ActionEvent event) {
        Model.getInstance().getViewFactory().handleLogout(event);
    }

}
