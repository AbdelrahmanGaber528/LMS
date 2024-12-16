module JavaFXTutorial {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.librarysystem.controller;
    exports com.librarysystem.app;
    opens com.librarysystem.controller to javafx.fxml;
    requires java.desktop;
    requires java.logging;



}
