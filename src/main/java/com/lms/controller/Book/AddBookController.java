package com.lms.controller.Book;

import com.lms.models.Book.Book;
import com.lms.service.Book.SaveBookService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBookController {

    @FXML
    public Button save_btn;
    @FXML
    public TextField title_id;
    @FXML
    public TextField author_id;
    @FXML
    public TextField amount_id;
    @FXML
    public TextField status_id;
    @FXML
    public TextField production_id;
    @FXML
    public ChoiceBox<String> categoryChoice_id;

    @FXML
    public void initialize() {

        ObservableList<String> categories = FXCollections.observableArrayList(
                "Fiction", "Non-Fiction", "Science", "History", "Biography"
        );

        categoryChoice_id.setItems(categories);

        categoryChoice_id.setValue("History");

        addListener();
    }

    private void addListener(){
        save_btn.setOnAction(this::saveBook);
    }

    private void saveBook(ActionEvent event) {

        String bookTitle = title_id.getText();
        String bookAuthor = author_id.getText();
        String bookAmount = amount_id.getText();
        String bookStatus = status_id.getText();

        Book newBook = new Book();
        newBook.setTitle(bookTitle);
        newBook.setAuthor(bookAuthor);
        newBook.setAmount(bookAmount);
        newBook.setCategory(categoryChoice_id.getValue());
        newBook.setStatus(bookStatus);

        SaveBookService.saveBook(newBook);
        closeWindow();
    }

    private void closeWindow(){
       Stage stage =  (Stage) save_btn.getScene().getWindow();
       stage.close();
    }

}
