package com.lms.view;

import com.lms.controller.Admin.AdminController;
import com.lms.controller.Librarian.LibrarianController;
import com.lms.controller.Patron.PatronController;
import com.lms.util.AdminMenuOptions;
import com.lms.util.LibrarianMenuOptions;
import com.lms.util.PatronMenuOptions;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.Objects;

public class ViewFactory {


    // Admin View
    private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;
    private AnchorPane profileView;
    private AnchorPane dashBoardView;
    private AnchorPane accountsView;
    private AnchorPane booksView;

    // Patron View
    private final ObjectProperty<PatronMenuOptions> patronSelectedItemMenu;
    private AnchorPane patronTransactions;
    private AnchorPane patronDashboardView;
    private AnchorPane patronBooksView;
    private AnchorPane patronProfileView;

    // Librarian View
    private final ObjectProperty<LibrarianMenuOptions> librarianSelectedItemMenu;


    public ViewFactory(){
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
        this.patronSelectedItemMenu = new SimpleObjectProperty<>();
        this.librarianSelectedItemMenu = new SimpleObjectProperty<>();
    }

    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem() {
        return adminSelectedMenuItem;
    }

    public AnchorPane getProfileView(){
        if(profileView == null){
            try{
                profileView = new FXMLLoader(getClass().getResource("/fxml/Admin/AdminProfile.fxml")).load();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
        return profileView;
    }

    public AnchorPane getAccountsView(){
        if(accountsView == null){
            try{
                accountsView = new FXMLLoader(getClass().getResource("/fxml/Admin/AdminAccounts.fxml")).load();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
        return accountsView;
    }

    public AnchorPane getBooksView(){
        if(booksView == null){
            try{
                booksView = new FXMLLoader(getClass().getResource("/fxml/Admin/AdminBooks.fxml")).load();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
        return booksView;
    }

    public AnchorPane getDashBoardView(){
        if(dashBoardView == null){
            try{
                dashBoardView = new FXMLLoader(getClass().getResource("/fxml/Admin/AdminDashboard.fxml")).load();
            }catch(Exception e ){
                System.err.println(e.getMessage());
            }
        }
            return dashBoardView;
    }


    public void showAdminWindow(){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Admin/Admin.fxml"));
        AdminController adminController = new AdminController();
        loader.setController(adminController);
        createStage(loader);
    }




    // Patron View

    public ObjectProperty<PatronMenuOptions> getPatronSelectedItemMenu() {
        return patronSelectedItemMenu;
    }

    public AnchorPane getPatronBooksView(){
        if(patronBooksView == null){
            try {
                patronBooksView = new FXMLLoader(getClass().getResource("/fxml/Patron/PatronBooks.fxml")).load();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return patronBooksView;
    }

    public AnchorPane getPatronProfileView(){
        if(patronProfileView == null){
            try {
                patronProfileView = new FXMLLoader(getClass().getResource("/fxml/Patron/PatronProfile.fxml")).load();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return patronProfileView;
    }


    public AnchorPane getPatronDashboardView(){
        if(patronDashboardView == null){
            try {
                patronDashboardView = new FXMLLoader(getClass().getResource("/fxml/Patron/PatronDashboard.fxml")).load();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return patronDashboardView;
    }



    public AnchorPane getPatronTransactionsView() {
        if (patronTransactions == null) {
            try {
                patronTransactions = new FXMLLoader(getClass().getResource("/fxml/Patron/PatronTransactions.fxml")).load();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return patronTransactions;
    }

    public void showPatronWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Patron/Patron.fxml"));
        PatronController patronController = new PatronController();
        loader.setController(patronController);
        createStage(loader);
    }




    // Librarian View

    public ObjectProperty<LibrarianMenuOptions> getLibrarianSelectedItemMenu(){
        return librarianSelectedItemMenu;
    }

    public void showLibrarianWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Librarian/Librarian.fxml"));
        LibrarianController librarianController = new LibrarianController();
        loader.setController(librarianController);
        createStage(loader);
    }


    public void showLoginWindow(){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));

        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/bookIcon.png"))));
        stage.setTitle("Library Management System" );
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    private void createStage(FXMLLoader loader){

        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        Stage stage = new Stage();
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/bookIcon.png"))));
        stage.setTitle("Library Management System");
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public  void handleLogout(ActionEvent event) {
        try{
            // Load the new FXML
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/login.fxml")));
            Scene scene = new Scene(root);

            // Get the current stage
            Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            currentStage.setResizable(false);
            currentStage.setScene(scene);
            currentStage.centerOnScreen();

        } catch (Exception e) {
            System.err.println("Error in logout :"+e.getMessage());
        }
    }

    public void closeStage(Stage stage){
        stage.close();
    }

}
