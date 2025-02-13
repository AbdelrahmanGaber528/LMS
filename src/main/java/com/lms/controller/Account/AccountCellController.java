package com.lms.controller.Account;

import com.lms.service.Account.AccountService;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountCellController implements Initializable {

    public Label accountID;

    public Label accountRole;

    public Label accountName;

    public Label active_id;

    public Button delete_Account;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        delete_Account.setOnAction(_ -> deleteAccount());
    }

    private void deleteAccount(){
        AccountService.deleteAccount(accountID.getText());
    }

}
