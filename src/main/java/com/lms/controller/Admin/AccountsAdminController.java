package com.lms.controller.Admin;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AccountsAdminController {
    public ChoiceBox<String> sort_accounts;
    public TextField searchbar;
    public Button search_btn;
    public Button newAccount_btn;
    public ListView<AnchorPane> accounts_list;
}
