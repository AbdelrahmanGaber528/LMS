package com.lms.controller.Admin;
import com.lms.service.Admin.AdminDashboardService;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable{

    public Text user_name;
    public Label login_date;
    public Label accounts_num;
    public Label patrons_acc_num;
    public Label librarian_acc_num;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
