package com.librarysystem.controller;

import com.librarysystem.dao.PatronDAO;
import com.librarysystem.models.Patron;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;

public class PatronController  {

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
    public List<Patron> getAllPatrons(){
        return new PatronDAO().getAllPatrons();
    } 
}

/*package com.librarysystem.controller;

import com.librarysystem.dao.PatronDAO;
import com.librarysystem.models.Patron;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;

public class PatronController {

    @FXML
    private TextField patronIdField;

    @FXML
    private TextField patronNameField;

    @FXML
    private TextField patronContactField;

    @FXML
    private TextField patronPreferencesField;

    private final PatronDAO patronDAO = new PatronDAO();

    @FXML
    public void handleLogout(ActionEvent event) {
        try {
            // Load the new FXML
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/login.fxml")));
            Scene scene = new Scene(root);

            // Get the current stage
            Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            currentStage.setResizable(false);
            currentStage.setScene(scene);
            currentStage.centerOnScreen();

        } catch (Exception e) {
            System.err.println("Error in logout: " + e.getMessage());
        }
    }

    public List<Patron> getAllPatrons() {
        return patronDAO.getAllPatrons();
    }

    @FXML
    public void handleAddPatron(ActionEvent event) {
        try {
            String name = patronNameField.getText().trim();
            String contact = patronContactField.getText().trim();
            String preferences = patronPreferencesField.getText().trim();

            if (name.isEmpty() || contact.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "Name and Contact cannot be empty.");
                return;
            }

            Patron patron = new Patron();
            patron.setAccount(null); // Account details can be set elsewhere if needed
            patron.setContact(contact);
            patron.setPreferences(preferences);

            patronDAO.addNewPatron(patron);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Patron added successfully.");

        } catch (Exception e) {
            System.err.println("Error adding patron: " + e.getMessage());
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to add patron.");
        }
    }

    @FXML
    public void handleDeletePatron(ActionEvent event) {
        try {
            String idText = patronIdField.getText().trim();

            if (idText.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "ID cannot be empty.");
                return;
            }

            Patron patron = new Patron();
            patron.setPatronId(idText);

            patronDAO.deletePatronAccount(patron);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Patron deleted successfully.");

        } catch (Exception e) {
            System.err.println("Error deleting patron: " + e.getMessage());
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to delete patron.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
 */