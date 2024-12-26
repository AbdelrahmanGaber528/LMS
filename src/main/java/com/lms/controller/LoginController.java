package com.lms.controller;

import com.lms.models.Account;
import com.lms.service.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class LoginController {

    @FXML
    public Label username_label;
    @FXML
    public TextField username_input;
    @FXML
    public Label pass_label;
    @FXML
    public TextField pass_input;
    @FXML
    public Button login_btn;
    @FXML
    public Label error_label;

    private final LoginService loginService = new LoginService();

    @FXML
    public void initialize(){
        username_input.setText("Abdelrahman");
        pass_input.setText("00000");
        error_label.setVisible(false);
    }

    @FXML
    public void handleLoginButton() {

        String userName = username_input.getText().trim();
        String password = pass_input.getText().trim();

        if (userName.isEmpty()) {
            error_label.setText("Please input UserName");
            error_label.setVisible(true);
            return;
        } else if (password.isEmpty()) {
            error_label.setText("Please input Password");
            error_label.setVisible(true);
            return;
        }

        Account user = loginService.login(userName, password);

        if (user != null) {
            error_label.setText("Login successful!");
            error_label.setStyle("-fx-text-fill: green;");
            loadRoleSpecificWindow(loginService.getRole(user.getAccountID()));
        } else {
            error_label.setText("Invalid Account");
            error_label.setStyle("-fx-text-fill: red;");
        }
        error_label.setVisible(true);
    }

    private void loadRoleSpecificWindow(String role) {
        try {
            String fxmlPath = switch (role) {
                case "Admin" -> "/fxml/Admin/admin.fxml";
                case "Librarian" -> "/fxml/Librarian/librarian.fxml";
                case "Patron" -> "/fxml/Patron/patron.fxml";
                default -> throw new IllegalArgumentException("Unknown role: " + role);
            };

            // Load the new FXML
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
            Scene scene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) login_btn.getScene().getWindow();
            stage.setResizable(false);
            stage.setTitle("Library Management System - " + role);
            stage.setScene(scene);
            stage.centerOnScreen();

        } catch (Exception e) {
            error_label.setText("Error loading the window");
            error_label.setVisible(true);
        }
    }

}
