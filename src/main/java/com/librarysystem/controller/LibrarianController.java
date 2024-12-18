    package com.librarysystem.controller;

import com.librarysystem.dao.LibrarianDAO;
import com.librarysystem.models.Librarian;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;

public class LibrarianController {

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

    public List<Librarian> getAllLibrarians(){
        return new LibrarianDAO().getAllLibrarians();
    }

}
/*package com.librarysystem.controller;

import com.librarysystem.dao.LibrarianDAO;
import com.librarysystem.models.Librarian;
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

public class LibrarianController {

    @FXML
    private TextField librarianIdField;

    @FXML
    private TextField librarianNameField;

    @FXML
    private TextField librarianContactField;

    @FXML
    private TextField librarianPreferencesField;

    private final LibrarianDAO librarianDAO = new LibrarianDAO();

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

    public List<Librarian> getAllLibrarians() {
        return librarianDAO.getAllLibrarians();
    }

    @FXML
    public void handleAddLibrarian(ActionEvent event) {
        try {
            String name = librarianNameField.getText().trim();
            String contact = librarianContactField.getText().trim();
            String preferences = librarianPreferencesField.getText().trim();

            if (name.isEmpty() || contact.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "Name and Contact cannot be empty.");
                return;
            }

            Librarian librarian = new Librarian();
            librarian.setAccount(null); // Account details can be set elsewhere if needed
            librarian.setContact(contact);
            librarian.setPreferences(preferences);

            librarianDAO.addLibrarianAccount(librarian);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Librarian added successfully.");

        } catch (Exception e) {
            System.err.println("Error adding librarian: " + e.getMessage());
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to add librarian.");
        }
    }

    @FXML
    public void handleDeleteLibrarian(ActionEvent event) {
        try {
            String idText = librarianIdField.getText().trim();

            if (idText.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "ID cannot be empty.");
                return;
            }

            Librarian librarian = new Librarian();
            librarian.setLibrarianId(idText);

            librarianDAO.deleteLibrarianAccount(librarian);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Librarian deleted successfully.");

        } catch (Exception e) {
            System.err.println("Error deleting librarian: " + e.getMessage());
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to delete librarian.");
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