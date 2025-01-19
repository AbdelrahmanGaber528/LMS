package com.lms.controller;

import com.lms.models.Account;
import com.lms.models.Model;
import com.lms.service.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
            error_label.setText("Error : Please input UserName");
            error_label.setVisible(true);
            return;
        } else if (password.isEmpty()) {
            error_label.setText("Error : Please input Password");
            error_label.setVisible(true);
            return;
        }

        Account user = loginService.login(userName, password);

        if (user != null) {
            error_label.setText("Login successful!");
            error_label.setStyle("-fx-text-fill: green;");
            loadRoleWindow(loginService.getRole(user.getAccountID()));
        } else {
            error_label.setText("Error : Invalid Account");
            error_label.setStyle("-fx-text-fill: red;");
        }
        error_label.setVisible(true);
    }

    private void loadRoleWindow(String role) {
        try {
            switch (role) {
                case "Admin" -> Model.getInstance().getViewFactory().showAdminWindow();
                case "Patron" -> Model.getInstance().getViewFactory().showPatronWindow();
                case "Librarian" -> Model.getInstance().getViewFactory().showLibrarianWindow();
                default -> throw new IllegalArgumentException("Unknown role: " + role);
            }
        } catch (Exception e) {
            error_label.setText("Error loading the window");
            error_label.setVisible(true);
        }
    }

}
