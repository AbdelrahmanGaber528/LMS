package com.lms.controller.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class AdminController{


//    @FXML
//    public void loadUsers() {
//        userTilePane.getChildren().clear();
//        List<Account> accounts = new AccountService().getAllUsers();
//        for (Account account : accounts) {
//            try {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/userCard.fxml"));
//                Node userCard = loader.load();
//
//                // Set user details and pass the TilePane reference
//                AccountCardController controller = loader.getController();
//                controller.setUserDetails(account, userTilePane);
//
//                userTilePane.getChildren().add(userCard);
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//            }
//        }
//    }

//    @FXML
//    public void handleNewUser(ActionEvent event){
//        // Create a new Stage (window)
//        Stage updateStage = new Stage();
//        updateStage.setTitle("Add User Information");
//
//        // Create a VBox layout for the form
//        VBox formLayout = new VBox(10);
//        formLayout.setPadding(new Insets(50));
//        formLayout.setAlignment(Pos.CENTER);
//
//        // Create labels and text fields for user information
//        Label nameLabel = new Label("Name:");
//        TextField nameField = new TextField();
//
//        Label passwordLabel = new Label("Password:");
//        TextField passwordField = new TextField();
//
//        Label roleLabel = new Label("Role:");
//        TextField roleField = new TextField();
//
//        Label contactLabel = new Label("Contact:");
//        TextField contactField = new TextField();
//
//        Label preferLabel = new Label("Preferences:");
//        TextField preferField = new TextField();
//
//        // Create Save and Cancel buttons
//        Button saveButton = new Button("Save");
//        saveButton.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-padding: 8 16;");
//        saveButton.setOnAction(e -> {
//            switch (roleField.getText()) {
//                case "Admin":
//                    Admin admin = new Admin();
//                    admin.getAccount().setUserName(nameField.getText());
//                    admin.getAccount().setPassword(passwordField.getText());
//                    admin.setContact(contactField.getText());
//                    admin.setPreferences(preferField.getText());
//                    adminService.addNewAdmin(admin);
//                    break;
//
//                case "Patron":
//                    Patron patron = new Patron();
//                    patron.getAccount().setUserName(nameField.getText());
//                    patron.getAccount().setPassword(passwordField.getText());
//                    patron.setContact(contactField.getText());
//                    patron.setPreferences(preferField.getText());
//                    new PatronService().addNewPatron(patron);
//                    break;
//
//                case "Librarian":
//                    Librarian librarian = new Librarian();
//                    librarian.getAccount().setUserName(nameField.getText());
//                    librarian.getAccount().setPassword(passwordField.getText());
//                    librarian.setContact(contactField.getText());
//                    librarian.setPreferences(preferField.getText());
//                    new LibrarianService().addNewLibrarian(librarian);
//                    break;
//
//                default:
//                    System.err.println("Unknown role");
//                    break;
//            }
//            // Close the update window
//            updateStage.close();
//        });
//
//        Button cancelButton = new Button("Cancel");
//        cancelButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-padding: 8 16;");
//        cancelButton.setOnAction(e -> updateStage.close());
//
//        // Add all elements to the layout
//        formLayout.getChildren().addAll(nameLabel, nameField, passwordLabel, passwordField,roleLabel,roleField ,contactLabel, contactField, preferLabel, preferField, saveButton, cancelButton);
//
//        // Set the scene and show the stage
//        Scene updateScene = new Scene(formLayout, 450, 410);
//        updateStage.setScene(updateScene);
//        updateStage.show();
//    }
//    @FXML
//    public void loadBooks() {
//        userTilePane.getChildren().clear();
//        List<Book> bookList = bookService.getAllBooks();
//        for(Book book : bookList) {
//            try {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/bookCard.fxml"));
//                Node bookCard = loader.load();
//                BookCardController controller = loader.getController();
//                controller.setBookDetails(book.getTitle(),book.getAuthor(),book.getCategory(),book.getStatus(),String.valueOf(book.getAmount()));
//                userTilePane.getChildren().add(bookCard);
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//            }
//        }
//    }



    @FXML
    public  void handleLogout(ActionEvent event) {
        try{
            // Load the new FXML
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/login.fxml")));
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
