package com.lms.controller.Admin;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable{

    public Text user_name;
    public Label login_date;
    public Label account_name1;
    public Label account_role1;
    public Label account_id_num1;
    public Label account_name2;
    public Label account_role2;
    public Label account_id_num2;
    public Label accounts_num;
    public Label patrons_acc_num;
    public Label librarian_acc_num;
    public ListView transaction_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
