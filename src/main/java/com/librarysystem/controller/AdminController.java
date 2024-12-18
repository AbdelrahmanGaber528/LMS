package com.librarysystem.controller;

import com.librarysystem.service.AdminService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.util.Objects;

public class AdminController{

    private final AdminService adminService = new AdminService();

    @FXML
    private Label  userName_message;

    @FXML
    private TilePane bookTilePane;

    @FXML
    public void handleDashBoard(ActionEvent event){

    }
    @FXML
    public  void handleLogout(ActionEvent event) {
        try{
            // Load the new FXML
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/login.fxml")));
            Scene scene = new Scene(root);

            // Get the current stage
            Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            currentStage.setResizable(false);
            currentStage.setScene(scene);
            currentStage.centerOnScreen();

        } catch (Exception e) {
            System.err.println("Error in logout :"+e.getMessage());
        }
    }
}
