package com.librarysystem.controller;

import com.librarysystem.service.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    private final LoginService loginService;

    public LoginController() {
        loginService = new LoginService();
    }

    @FXML
    public void handleLoginButton(ActionEvent event) {
        String userName = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (userName.isEmpty()) {
            errorLabel.setText("Please input UserName");
            errorLabel.setVisible(true);
            return;
        } else if (password.isEmpty()) {
            errorLabel.setText("Please input Password");
            errorLabel.setVisible(true);
            return;
        }

        boolean isValid = loginService.login(userName, password);

        if (isValid) {
            errorLabel.setText("Login successful!");
            errorLabel.setLayoutX(155);
            errorLabel.setStyle("-fx-text-fill: green;");
        } else {
            errorLabel.setText("Invalid Account.");
            errorLabel.setLayoutX(158);
            errorLabel.setStyle("-fx-text-fill: red;");
        }
        errorLabel.setVisible(true);
    }

}
