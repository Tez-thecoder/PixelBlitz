package com.example.fxml_manual;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

class menu_bar {
    soundApi s_bj = new soundApi();
    public void documentation_event(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("documentation.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            //Node stage2;
            stage.getScene().setRoot(gameSelectionRoot);

        } catch (IOException e) {
            System.out.println("Something went wrong loading game_documentation.fxml: " + e.getMessage());

        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception Caught " + e);

        } catch (Exception e) {
            System.out.println("Exception Caught" + e);
        }
    }

    public void references_event(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("References.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            //Node stage2;
            stage.getScene().setRoot(gameSelectionRoot);

        } catch (IOException e) {
            System.out.println("Something went wrong loading reference.fxml: " + e.getMessage());

        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception Caught " + e);

        } catch (Exception e) {
            System.out.println("Exception Caught" + e);
        }

    }

    public void credits_event(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Credits.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            //Node stage2;
            stage.getScene().setRoot(gameSelectionRoot);


        } catch (IOException e) {
            System.out.println("Something went wrong loading Credits.fxml: " + e.getMessage());

        }

    }

    public void license_event(Stage stage) {
        try {
            if (stage == null) {
                System.out.println("Stage is null inside license_event() method");
            } else {
                System.out.println("Stage is not null inside license_event() method");
            }
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("license.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            //Node stage2;
            Objects.requireNonNull(stage).getScene().setRoot(gameSelectionRoot);

        } catch (IOException e) {
            System.out.println("Something went wrong loading game_documentation.fxml: " + e.getMessage());

        }

    }
    public void easter_egg_event(Stage stage){
        try {
            if (stage == null) {
                System.out.println("Stage is null inside license_event() method");
            } else {
                System.out.println("Stage is not null inside license_event() method");
            }
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("easterEgg.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            //Node stage2;
            Objects.requireNonNull(stage).getScene().setRoot(gameSelectionRoot);

        } catch (IOException e) {
            System.out.println("Something went wrong loading game_documentation.fxml: " + e.getMessage());

        }

    }



    public void faq_event(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("faq.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            //Node stage2;
            stage.getScene().setRoot(gameSelectionRoot);

        } catch (IOException e) {
            System.out.println("Something went wrong loading game_documentation.fxml: " + e.getMessage());

        }

    }

    public void termsAndConditionsEvent(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("t_and_c.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            //Node stage2;
            stage.getScene().setRoot(gameSelectionRoot);

        } catch (IOException e) {
            System.out.println("Something went wrong loading game_documentation.fxml: " + e.getMessage());
            //e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception Caught " + e);
        } catch (Exception e) {
            System.out.println("Exception Caught" + e);
        }
    }

    public void force_exit_event() {
        Platform.exit();

    }

    public void mute_audio_event() {

    }
}
