module com.lms{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    opens com.lms to javafx.fxml;
    exports com.lms ;
    exports com.lms.controller;
    exports com.lms.controller.Admin;
    exports com.lms.controller.Patron;
    exports com.lms.controller.Librarian;
    exports com.lms.models;
    exports com.lms.view;
    exports com.lms.models.Admin;
    exports com.lms.models.Librarian;
    exports com.lms.models.Patron;
    exports com.lms.models.Book;
    exports com.lms.models.Transaction;

}
