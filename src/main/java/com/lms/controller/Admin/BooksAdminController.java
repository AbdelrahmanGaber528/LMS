package com.lms.controller.Admin;

import com.lms.models.Book.Book;
import com.lms.models.Model;
import com.lms.service.Book.GetAllBooks;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    public ListView<AnchorPane> books_list_admin;

    @FXML
    public ChoiceBox<String> sort_books;

    private final ObservableList<AnchorPane> booksList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        ObservableList<String> sort_list = FXCollections.observableArrayList(
                "Name", "ID", "Date", "Category", "Author"
        );

        sort_books.setItems(sort_list);
        sort_books.setValue("ID");

        getAllBooks();
        books_list_admin.setItems(booksList);
        addListener();
    }


    private void onSearch(){
        String keyWord = searchbar.getText(0,5);
    }


    private  void addListener(){
        newBook_btn.setOnAction(_ -> onAddBook());
        search_btn.setOnAction(_ -> onSearch());
    }

    private Book getBookFromAnchorPane(AnchorPane pane1) {

        Book book = new Book();
        Label id =(Label) pane1.lookup("#bookID");
        book.setBookId(id.getText());
        Label title = (Label) pane1.lookup("#bookTitle");
        book.setTitle(title.getText());
        Label author = (Label) pane1.lookup("#bookAuthor");
        book.setAuthor(author.getText());
        Label status = (Label) pane1.lookup("#bookStatus");
        book.setStatus(status.getText());
        Label amount = (Label) pane1.lookup("#bookAmount");
        book.setAmount(amount.getText());
        Label category = (Label) pane1.lookup("#bookCategory");
        book.setCategory(category.getText());

        return book;
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
