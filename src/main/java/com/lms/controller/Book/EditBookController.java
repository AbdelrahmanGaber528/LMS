package com.lms.controller.Book;

import com.lms.models.Book.Book;
import com.lms.service.Book.EditBookService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class EditBookController {

    public TextField title_id;
    public TextField author_id;
    public TextField amount_id;
    public TextField production_id;
    public ChoiceBox<String> categoryChoice_id;
    public TextField status_id;
    public Button save_btn;
    public Button cancel_btn;
    private String id;

    @FXML
    public void initialize() {

        ObservableList<String> categories = FXCollections.observableArrayList(
                "Fiction", "Non-Fiction", "Science", "History", "Biography"
        );

        categoryChoice_id.setItems(categories);

        addListener();
    }

    public void setTitle_id(String title_id) {
        this.title_id.setText(title_id);
    }

    public void setAuthor_id(String author_id) {
        this.author_id.setText(author_id);
    }

    public void setId(String id){
        this.id = id;
    }

    public void setAmount_id(String amount_id) {
        this.amount_id.setText(amount_id);
    }

    public void setProduction_id(String production_id) {
        this.production_id.setText(production_id);
    }

    public void setCategoryChoice_id(String categoryChoice_id) {
        this.categoryChoice_id.setValue(categoryChoice_id);
    }

    public void setStatus_id(String status_id) {
        this.status_id.setText(status_id);
    }

    private void addListener(){
        save_btn.setOnAction(this::saveBook);
        cancel_btn.setOnAction(_ -> closeWindow());
    }

    private void saveBook(ActionEvent event) {

        String bookTitle = title_id.getText();
        String bookAuthor = author_id.getText();
        String bookAmount = amount_id.getText();
        String bookStatus = status_id.getText();

        Book editedBook = new Book();
        editedBook.setTitle(bookTitle);
        editedBook.setAuthor(bookAuthor);
        editedBook.setAmount(bookAmount);
        editedBook.setCategory(categoryChoice_id.getValue());
        editedBook.setStatus(bookStatus);
        editedBook.setBookId(id);
        editedBook.setProductionDate(LocalDate.parse(production_id.getText()));
        EditBookService.editBook(editedBook);

        closeWindow();
    }

    private void closeWindow(){
        Stage stage =  (Stage) save_btn.getScene().getWindow();
        stage.close();
    }

}
