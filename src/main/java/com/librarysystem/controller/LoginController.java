package com.librarysystem.controller;

import com.librarysystem.models.Account;
import com.librarysystem.service.AccountService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private  Button loginButton;

    private final AccountService accountService;

    public LoginController() {
        accountService = new AccountService();
    }

    @FXML
    public void handleLoginButton(ActionEvent event) {
        String userName = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        usernameField.setText("Mohammed");
        passwordField.setText("0000");
        if (userName.isEmpty()) {
            errorLabel.setText("Please input UserName");
            errorLabel.setVisible(true);
            return;
        } else if (password.isEmpty()) {
            errorLabel.setText("Please input Password");
            errorLabel.setVisible(true);
            return;
        }

        Account user = accountService.login(userName, password);

        if (user != null) {
            errorLabel.setText("Login successful!");
            errorLabel.setLayoutX(155);
            errorLabel.setStyle("-fx-text-fill: green;");
            loadRoleSpecificWindow(accountService.getRole(user.getAccountID()));
        } else {
            errorLabel.setText("Invalid Account");
            errorLabel.setLayoutX(158);
            errorLabel.setStyle("-fx-text-fill: red;");
        }
        errorLabel.setVisible(true);
    }


    private void loadRoleSpecificWindow(String role) {
        try {
            String fxmlPath = switch (role) {
                case "Admin" -> "/view/admin.fxml";
                case "Librarian" -> "/view/librarian.fxml";
                case "Patron" -> "/view/patron.fxml";
                default -> throw new IllegalArgumentException("Unknown role: " + role);
            };

            // Load the new FXML
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
            Scene scene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setResizable(false);
            stage.setTitle("Library Management System - " + role);
            stage.setScene(scene);
            stage.centerOnScreen();

        } catch (Exception e) {
            errorLabel.setText("Error loading the window");
            errorLabel.setLayoutX(135);
            errorLabel.setVisible(true);
        }
    }

}
