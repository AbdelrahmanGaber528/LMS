package com.librarysystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;

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
    private ImageView bookImage;
    @FXML
    private Label bookAmount;
    @FXML
    private Button viewDetailsButton;

    public void setBookDetails(String title, String author, String genre, String availability, String amount) {
        bookTitle.setText(title);
        bookAuthor.setText(author);
        bookGenre.setText(genre);
        bookAvailability.setText(availability);
        bookAmount.setText(amount);
    }

}
