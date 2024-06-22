package com.example.fxml_manual;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class loadingAnimation {

    private final ProgressBar progressBar = new ProgressBar(0);

    public void animationLoad(Stage stage) {
        try {
            System.out.println("Loading fxml file preview");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loadingScreen.fxml"));
            AnchorPane anchorPane = loader.load(); // Load the AnchorPane from FXML

            // Create a scene with the loaded AnchorPane
            Scene loadingScene = new Scene(anchorPane);

            LoadingScreenController controller = loader.getController();

            // Show loading screen
            stage.setScene(loadingScene);
            stage.setTitle("Loading...");
            stage.show();

            new Thread(() -> {
                try {
                    // Simulate loading
                    Thread.sleep(2000);

                    // Update progress bar on UI thread
                    Platform.runLater(() -> controller.setProgress(1.0));
                } catch (InterruptedException e) {
                    System.out.println("Interrupted Exception Caught: " + e);
                }
            }).start();

        } catch (IOException e) {
            System.out.println("IOException caught: " + e);
            e.printStackTrace();
        }
    }

}

