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
    private TilePane userTilePane ;

    @FXML
    private Label accountId;

    @FXML
    private Label role;

    public void setUserDetails(Account account) {
        userName.setText(account.getUserName());
        accountId.setText(account.getAccountID());
        role.setText(account.getRole());
    }

    @FXML
    public void handleDetails(ActionEvent event){

    }

    private String getAccountID() {
        return accountId.getText();
    }


}
