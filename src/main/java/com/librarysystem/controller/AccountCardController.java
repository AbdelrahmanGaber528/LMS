package com.librarysystem.controller;

import com.librarysystem.models.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;

public class AccountCardController {

    @FXML
    private Label userName;

    @FXML
    private Label accountId;

    @FXML
    private Label role;

    private TilePane parentTilePane; // Reference to the parent TilePane
    private Account account;         // Current user details

    public void setUserDetails(Account account, TilePane parentTilePane) {
        this.account = account;
        this.parentTilePane = parentTilePane;
        userName.setText(account.getUserName());
        accountId.setText(account.getAccountID());
        role.setText(account.getRole());
    }

    @FXML
    public void handleDetails(ActionEvent event) {
        // Clear all cards from the parent TilePane
        parentTilePane.getChildren().clear();

        // Create and display detailed information about the user
        Label detailsLabel = new Label("User Details:");
        detailsLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #0082ff;");

        Label userNameLabel = new Label("Name: " + account.getUserName());
        userNameLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #343a40;");

        Label userIdLabel = new Label("ID: " + account.getAccountID());
        userIdLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #343a40;");

        Label roleLabel = new Label("Role: " + account.getRole());
        roleLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #343a40;");

        parentTilePane.getChildren().addAll(detailsLabel, userNameLabel, userIdLabel, roleLabel);
    }
}
