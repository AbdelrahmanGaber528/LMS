package com.lms.controller.Patron;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PatronDashboardController  implements Initializable {

    public Text user_name;
    public Label login_date;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_date.setText(LocalDate.now().toString());
    }
}
