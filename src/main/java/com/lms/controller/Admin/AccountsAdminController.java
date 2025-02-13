package com.lms.controller.Admin;

import com.lms.models.Account;
import com.lms.models.Model;
import com.lms.service.Account.GetAllAccounts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AccountsAdminController implements Initializable {

    public TextField searchbar;

    public Button search_btn;

    public Button newAccount_btn;

    public ListView<AnchorPane> accounts_list;


    public ChoiceBox<String> accounts_choice;


    public final ObservableList<AnchorPane> accountsObserveList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> sort_list = FXCollections.observableArrayList(
                "Name", "ID", "Role"
        );

        accounts_choice.setItems(sort_list);
        accounts_choice.setValue("Name");

        getAllAccounts();
        accounts_list.setItems(accountsObserveList);
        addListener();
    }

    private void addListener(){
        newAccount_btn.setOnAction(_ -> onAddAccount());
        search_btn.setOnAction(_ -> onSearch());
    }

    private void onAddAccount(){

    }

    private void onSearch(){
        String value = accounts_choice.getValue();
        switch (value){
            case "ID" -> accounts_list.setItems(searchByID(searchbar.getText(),accountsObserveList));
            case "Name" -> accounts_list.setItems(searchByName(searchbar.getText(),accountsObserveList));
            case "Role" -> accounts_list.setItems(searchByRole(searchbar.getText(),accountsObserveList));
        }
    }

    private ObservableList<AnchorPane> searchByID(String searchWord, ObservableList<AnchorPane> listOfUsers) {
        if (searchWord == null || searchWord.trim().isEmpty() || searchWord.trim().contains("I") || searchWord.trim().contains("i")) {
            return listOfUsers;
        }
        ObservableList<AnchorPane> resultList = FXCollections.observableArrayList();
        resultList.add(getHeader());
        for (AnchorPane anchorPane : listOfUsers) {
            Node node = anchorPane.lookup("#accountID");
            if (node instanceof Label label) {
                if (label.getText().toLowerCase().contains(searchWord.toLowerCase())) {
                    resultList.add(anchorPane);
                }
            }
        }
        return resultList;
    }

    private ObservableList<AnchorPane> searchByName(String searchWord, ObservableList<AnchorPane> listOfUsers) {
        if (searchWord == null || searchWord.trim().isEmpty()) {
            return listOfUsers;
        }
        ObservableList<AnchorPane> resultList = FXCollections.observableArrayList();
        resultList.add(getHeader());
        for (AnchorPane anchorPane : listOfUsers) {
            Node node = anchorPane.lookup("#accountName");
            if (node instanceof Label label) {
                if (label.getText().toLowerCase().contains(searchWord.toLowerCase())) {
                    resultList.add(anchorPane);
                }
            }
        }
        return resultList;
    }

    private ObservableList<AnchorPane> searchByRole(String searchWord, ObservableList<AnchorPane> listOfUsers) {
        if (searchWord == null || searchWord.trim().isEmpty()) {
            return listOfUsers;
        }
        ObservableList<AnchorPane> resultList = FXCollections.observableArrayList();
        resultList.add(getHeader());
        for (AnchorPane anchorPane : listOfUsers) {
            Node node = anchorPane.lookup("#accountRole");
            if (node instanceof Label label) {
                if (label.getText().toLowerCase().contains(searchWord.toLowerCase())) {
                    resultList.add(anchorPane);
                }
            }
        }
        return resultList;
    }

    private void getAllAccounts(){
        List<Account> accounts = GetAllAccounts.getAllAccounts();
        accountsObserveList.add(getHeader());
        for(Account account : accounts ){
            accountsObserveList.add(newAccountCell(account));
        }
    }

    private AnchorPane newAccountCell(Account account){
        return Model.getInstance().getViewFactory().getAccountCell(account);
    }

    private AnchorPane getHeader(){
        return Model.getInstance().getViewFactory().getAccountHeader();
    }
}
