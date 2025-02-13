package com.lms.controller.Book;

import com.lms.service.Book.DeleteBookService;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BookCellController implements Initializable {


    public Label bookID;

    public Label bookTitle;

    public Label bookAuthor;

    public Label bookCategory;

    public Label bookProduction;

    public Label bookStatus;

    public Label bookAmount;

    public Button edit_book;

    public Button delete_book;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListener();
    }

    private void addListener(){
        delete_book.setOnAction(_ -> deleteBook());
        edit_book.setOnAction(_ ->editBook());
    }

    private void deleteBook(){
        DeleteBookService.deleteBook(Integer.parseInt(bookID.getText()));
    }

    private void editBook(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Book/editBook.fxml"));
            Parent view = loader.load();
            Scene scene = new Scene(view, 850, 750);
            EditBookController controller = loader.getController();
            controller.setTitle_id(bookTitle.getText());
            controller.setAmount_id(bookAmount.getText());
            controller.setCategoryChoice_id(bookCategory.getText());
            controller.setStatus_id(bookStatus.getText());
            controller.setId(bookID.getText());
            controller.setProduction_id(bookProduction.getText());
            controller.setAuthor_id(bookAuthor.getText());
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.setTitle("Edit Book!");
            newStage.setResizable(false);
            newStage.show();
        } catch (Exception e) {
            System.err.println("Error loading Edit Book window: " + e.getMessage());
        }
    }

}