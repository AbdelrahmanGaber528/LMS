package com.librarysystem.controller;

import com.librarysystem.models.Account;
import com.librarysystem.models.Book;
import com.librarysystem.service.AccountService;
import com.librarysystem.service.AdminService;
import com.librarysystem.service.BookService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;

public class AdminController{

    private final AdminService adminService = new AdminService();

    @FXML
    private TilePane userTilePane;

    private final BookService bookService = new BookService();

    @FXML
    public void initialize(){
    }

    @FXML
    public void loadUsers(){
        userTilePane.getChildren().clear();
        List<Account> accounts = new AccountService().getAllUsers();
        for(Account account : accounts){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/userCard.fxml"));
                Node userCard = loader.load();
                AccountCardController controller = loader.getController();
                controller.setUserDetails(account);
                userTilePane.getChildren().add(userCard);
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }

    @FXML
    public void loadBooks() {
        userTilePane.getChildren().clear();
        List<Book> bookList = bookService.getAllBooks();
        for(Book book : bookList) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/bookCard.fxml"));
                Node bookCard = loader.load();
                BookCardController controller = loader.getController();
                controller.setBookDetails(book.getTitle(),book.getAuthor(),book.getCategory(),book.getStatus(),String.valueOf(book.getAmount()));
                userTilePane.getChildren().add(bookCard);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @FXML
    public  void handleLogout(ActionEvent event) {
        try{
            // Load the new FXML
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/login.fxml")));
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
}
