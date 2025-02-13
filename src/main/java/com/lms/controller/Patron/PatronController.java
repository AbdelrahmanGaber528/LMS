package com.lms.controller.Patron;

import com.lms.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import com.lms.util.PatronMenuOptions;
import java.util.ResourceBundle;

public class PatronController  implements Initializable {

    public BorderPane patron_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Model.getInstance().getViewFactory().getPatronSelectedItemMenu().addListener((observable , oldVal , newVal)->{
            switch (newVal){
                case PatronMenuOptions.BOOKS -> patron_parent.setCenter(Model.getInstance().getViewFactory().getPatronBooksView());
                case PatronMenuOptions.TRANSACTIONS -> patron_parent.setCenter(Model.getInstance().getViewFactory().getPatronTransactionsView());
                case PatronMenuOptions.PROFILE -> patron_parent.setCenter(Model.getInstance().getViewFactory().getPatronProfileView());
                default -> patron_parent.setCenter(Model.getInstance().getViewFactory().getPatronDashboardView());
            }
        } );

    }

}
