package com.lms.controller.Patron;

import com.lms.models.Model;
import com.lms.util.PatronMenuOptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class PatronMenuController implements Initializable {

    @FXML
    public Text name_of_patron;
    @FXML
    public Button dashboard_id;
    @FXML
    public Button books_id;
    @FXML
    public Button transaction_id;
    @FXML
    public Button profile_id;
    @FXML
    public Button logout_id;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners(){
        dashboard_id.setOnAction(_ -> onDashboard());
        books_id.setOnAction(_ -> onBooks());
        profile_id.setOnAction(_ -> onProfile());
        transaction_id.setOnAction(_ -> onTransactions());
        logout_id.setOnAction(this::onLogout);
    }

    private void onDashboard(){
        Model.getInstance().getViewFactory().getPatronSelectedItemMenu().set(PatronMenuOptions.DASHBOARD);
    }

    private void onBooks(){
        Model.getInstance().getViewFactory().getPatronSelectedItemMenu().set(PatronMenuOptions.BOOKS);
    }

    private void onProfile(){
        Model.getInstance().getViewFactory().getPatronSelectedItemMenu().set(PatronMenuOptions.PROFILE);
    }

    private void onTransactions(){
        Model.getInstance().getViewFactory().getPatronSelectedItemMenu().set(PatronMenuOptions.TRANSACTIONS);
    }

    private void onLogout(ActionEvent event){
        Model.getInstance().getViewFactory().handleLogout(event);
    }

}
