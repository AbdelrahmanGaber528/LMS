package com.lms.controller.Admin;

import com.lms.models.Book.Book;
import com.lms.models.Model;
import com.lms.service.Book.GetAllBooks;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class BooksAdminController implements Initializable {

    @FXML
    public TextField searchbar;
    @FXML
    public Button search_btn;
    @FXML
    public  Button newBook_btn;
    @FXML
    public  ListView<AnchorPane> books_list_admin;

    @FXML
    public ChoiceBox<String> books_Choice;

    public final ObservableList<AnchorPane> booksList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> sort_list = FXCollections.observableArrayList(
                "Title", "ID", "Category", "Author"
        );

        books_Choice.setItems(sort_list);
        books_Choice.setValue("Title");

        getAllBooks();
        books_list_admin.setItems(booksList);
        addListener();
    }

    private  void addListener(){
        newBook_btn.setOnAction(_ -> onAddBook());
        search_btn.setOnAction(_ -> onSearch());
    }

    private void onSearch(){
        String value = books_Choice.getValue();
        switch (value){
            case "Title" -> books_list_admin.setItems(searchListByTitle(searchbar.getText(),booksList));
            case "ID" -> books_list_admin.setItems(searchListByID(searchbar.getText(),booksList));
            case "Author" -> books_list_admin.setItems(searchListByAuthor(searchbar.getText(),booksList));
            case "Category" -> books_list_admin.setItems(searchListByCategory(searchbar.getText(),booksList));
        }
    }

    private ObservableList<AnchorPane> searchListByAuthor(String searchWord, ObservableList<AnchorPane> listOfThings) {
        if (searchWord == null || searchWord.trim().isEmpty()) {
            return listOfThings;
        }
        ObservableList<AnchorPane> resultList = FXCollections.observableArrayList();
        resultList.add(getHeader());
        for (AnchorPane anchorPane : listOfThings) {
            Node node = anchorPane.lookup("#bookAuthor");
            if (node instanceof Label label) {
                if (label.getText().toLowerCase().contains(searchWord.toLowerCase())) {
                    resultList.add(anchorPane);
                }
            }
        }
        return resultList;
    }

    private ObservableList<AnchorPane> searchListByCategory(String searchWord, ObservableList<AnchorPane> listOfThings) {
        if (searchWord == null || searchWord.trim().isEmpty()) {
            return listOfThings;
        }
        ObservableList<AnchorPane> resultList = FXCollections.observableArrayList();
        resultList.add(getHeader());
        for (AnchorPane anchorPane : listOfThings) {
            Node node = anchorPane.lookup("#bookCategory");
            if (node instanceof Label label) {
                if (label.getText().toLowerCase().contains(searchWord.toLowerCase())) {
                    resultList.add(anchorPane);
                }
            }
        }
        return resultList;
    }

    private ObservableList<AnchorPane> searchListByID(String searchWord, ObservableList<AnchorPane> listOfThings) {
        if (searchWord == null || searchWord.trim().isEmpty()) {
            return listOfThings;
        }
        ObservableList<AnchorPane> resultList = FXCollections.observableArrayList();
        resultList.add(getHeader());
        for (AnchorPane anchorPane : listOfThings) {
            Node node = anchorPane.lookup("#bookID");
            if (node instanceof Label label) {
                if (label.getText().toLowerCase().contains(searchWord.toLowerCase())) {
                    resultList.add(anchorPane);
                }
            }
        }
        return resultList;
    }

    private ObservableList<AnchorPane> searchListByTitle(String searchWord , ObservableList<AnchorPane>  listOfThings){
        if (searchWord == null || searchWord.trim().isEmpty()) {
            return listOfThings;
        }
        ObservableList<AnchorPane> resultList = FXCollections.observableArrayList();
        resultList.add(getHeader());
        for (AnchorPane anchorPane : listOfThings) {
            Node node = anchorPane.lookup("#bookTitle");
            if (node instanceof Label label) {
                if (label.getText().toLowerCase().contains(searchWord.toLowerCase())) {
                    resultList.add(anchorPane);
                }
            }
        }
        return resultList;
    }

    private void onAddBook() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Book/AddBook.fxml"));
        try {
        Parent view = loader.load();
            Scene scene = new Scene(view, 850, 750);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.setTitle("Add New Book");
            newStage.setResizable(false);
            newStage.show();
        } catch (Exception e) {
            System.err.println("Error loading Add Book window: " + e.getMessage());
        }
    }

    private void getAllBooks() {
        List<Book> books = GetAllBooks.getAllBooks();
        booksList.add(getHeader());
        for(Book book : books ){
            booksList.add(newBookCell(book));
        }
    }

    private AnchorPane newBookCell(Book book ){
        return Model.getInstance().getViewFactory().getBookView(book);
    }

    private AnchorPane getHeader(){
        return Model.getInstance().getViewFactory().getHeaderBook();
    }

}
