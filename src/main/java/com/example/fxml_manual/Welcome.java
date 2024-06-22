package com.example.fxml_manual;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.awt.*;

class Welcome {

    private Stage stage;
    private Scene scene;
    private Parent parent;
    public void welMsg(){
        Stage stage = new Stage();
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root,1000,1000);
        FXMLLoader fxmlLoader = new FXMLLoader(PixelBlitz.class.getResource("title_screen.fxml"));
        stage.setScene(scene);
        System.out.println("Welcome!");
        Label label = new Label("Welcome to our Application Pixel Blitz");
        label.setText(String.valueOf(label));
        stage.setTitle("Welcome");
        stage.show();
    }
    public void codeExecuted(){
        System.out.println("Code is now running");
    }
}
