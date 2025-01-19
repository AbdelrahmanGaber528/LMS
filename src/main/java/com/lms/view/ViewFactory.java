package com.lms.view;

import com.lms.controller.Admin.AdminController;
import com.lms.controller.Librarian.LibrarianController;
import com.lms.controller.Patron.PatronController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.Objects;

public class ViewFactory {


    // Admin View
    private AnchorPane dashBoardView;

    public ViewFactory(){}

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
        stage.setTitle("Library Management System");
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public void showAdminWindow(){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Admin/Admin.fxml"));
        AdminController adminController = new AdminController();
        loader.setController(adminController);
        createStage(loader);
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


    public void closeStage(Stage stage){
        stage.close();
    }

    public void showPatronWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Patron/Patron.fxml"));
        PatronController patronController = new PatronController();
        loader.setController(patronController);
        createStage(loader);
    }

    public void showLibrarianWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Librarian/Librarian.fxml"));
        LibrarianController librarianController = new LibrarianController();
        loader.setController(librarianController);
        createStage(loader);
    }

}
