package com.lms.view;

import com.lms.controller.Admin.AdminController;
import com.lms.controller.Librarian.LibrarianController;
import com.lms.controller.Patron.PatronController;
import com.lms.models.Account;
import com.lms.models.Book.Book;
import com.lms.util.AdminMenuOptions;
import com.lms.util.LibrarianMenuOptions;
import com.lms.util.PatronMenuOptions;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
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

    // Admin

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
                accountsView = new FXMLLoader(getClass().getResource("/fxml/Admin/Accounts.fxml")).load();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
        return accountsView;
    }

    public AnchorPane getBooksView(){
        if(booksView == null){
            try{
                booksView = new FXMLLoader(getClass().getResource("/fxml/Admin/Books.fxml")).load();
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


    // Accounts View

    public AnchorPane getAccountCell(Account account){

        AnchorPane newAccount = null ;

        try{
            newAccount = new FXMLLoader(getClass().getResource("/fxml/Account/AccountCell.fxml")).load();

            Label idLabel = (Label) newAccount.lookup("#accountID");
            Label nameLabel = (Label) newAccount.lookup("#accountName");
            Label roleLabel = (Label) newAccount.lookup("#accountRole");
            Label activeLabel = (Label) newAccount.lookup("#active_id");

            idLabel.setText(account.getAccountID());
            nameLabel.setText(account.getUserName());
            roleLabel.setText(account.getRole());
            activeLabel.setText(account.isActive());
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
        return newAccount;
    }

    public AnchorPane getAccountHeader(){
        AnchorPane header = null;
        try{
            header = new FXMLLoader(getClass().getResource("/fxml/Account/AccountHeader.fxml")).load();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return header;
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


    // Book View


    public AnchorPane getBookView(Book book){

        AnchorPane newBook = null ;
        try{
            newBook = new FXMLLoader(getClass().getResource("/fxml/Book/BookCell.fxml")).load();

            Label idLabel = (Label) newBook.lookup("#bookID");
            Label titleLabel = (Label) newBook.lookup("#bookTitle");
            Label authorLabel = (Label) newBook.lookup("#bookAuthor");
            Label categoryLabel = (Label) newBook.lookup("#bookCategory");
            Label availableLabel = (Label) newBook.lookup("#bookStatus");
            Label amuontLabel = (Label) newBook.lookup("#bookAmount");
            Label productionLabel = (Label) newBook.lookup("#bookProduction");

            idLabel.setText(String.valueOf(book.getBookId()));
            titleLabel.setText(book.getTitle());
            authorLabel.setText(book.getAuthor());
            categoryLabel.setText(book.getCategory());
            availableLabel.setText(Boolean.parseBoolean(book.getStatus()) ? "Yes" : "No");
            amuontLabel.setText(String.valueOf(book.getAmount()));
            productionLabel.setText(String.valueOf(book.getProductionDate()));

        }catch(IOException e){
            System.err.println(e.getMessage());
        }
        return newBook;
    }

    public AnchorPane getHeaderBook(){

        AnchorPane header = null;
        try{
            header = new FXMLLoader(getClass().getResource("/fxml/Book/BookHeader.fxml")).load();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return header;
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
