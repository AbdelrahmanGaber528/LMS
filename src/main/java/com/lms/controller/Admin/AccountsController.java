package com.lms.controller.Admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AccountsController {

    @FXML
    private TextField searchbar;

    @FXML
    private Button search_btn;

    @FXML
    private Button newAccount_btn;

    @FXML
    private ListView<AnchorPane> accounts_list;


}
