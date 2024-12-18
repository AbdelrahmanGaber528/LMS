package com.librarysystem.controller;

import com.librarysystem.service.BookService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BookCardController {
    @FXML
    private Label bookTitle;

    @FXML
    private Label bookAuthor;

    @FXML
    private Label bookGenre;

    @FXML
    private Label bookAvailability;

    @FXML
    private Button viewDetailsButton;


    private final BookService bookService = new BookService();

    public void setBookDetails(String title, String author, String genre, String availability) {

    }
}
