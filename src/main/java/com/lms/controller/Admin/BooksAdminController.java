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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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

        ObservableList<String> categories = FXCollections.observableArrayList(
                "Name", "ID" , "Date"
        );

        sort_books.setItems(categories);

        sort_books.setValue("ID");

        getAllBooks();
        books_list_admin.setItems(booksList);
        addListener();
    }



    private  void addListener(){
        newBook_btn.setOnAction(_ -> onAddBook());
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
