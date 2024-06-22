package com.example.fxml_manual;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
//Pixel Blitz is the main application class
public class PixelBlitz extends Application {
    private final loadingAnimation load_obj = new loadingAnimation();
    private final soundApi obj_sound = new soundApi();
    private final Welcome obj_wel = new Welcome();
    @Override
    public void start(Stage stage) throws IOException {
        /* */
        /* */
        //

        //welcome screen load
        try{
            obj_wel.codeExecuted();
        } catch (Exception e){
            System.out.println("Something went wrong while loading welcome class");
        }
//        load_obj.animationLoad(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(PixelBlitz.class.getResource("title_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 1000, Color.GRAY);
        //link css
        try{
            //scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styler.css")).toExternalForm());
            String css;
            css = Objects.requireNonNull(this.getClass().getResource("styler.css")).toExternalForm();
            scene.getStylesheets().add(css);
            System.out.println("Css file found!");

        }
        catch(NullPointerException e){
            System.out.println(" Null pointer Exception Caught" + e);
        }
        catch (Exception e){
            System.out.println("Exception Caught" + e);
        }
        //sound api


        // Get the controller instance
        titleScreen_ControllerClass controller_one = fxmlLoader.getController();

        // Pass the stage reference to the controller
        controller_one.setStage(stage);
        //play sound function
        obj_sound.play_sound();

        stage.setTitle("Pixel Blitz!");
        stage.setFullScreen(false);
        stage.setResizable(false);
        /*Audio  API*/



        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();



    }
}



