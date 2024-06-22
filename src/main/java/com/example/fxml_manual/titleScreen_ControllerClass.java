package com.example.fxml_manual;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.media.MediaView;


public class titleScreen_ControllerClass implements Initializable {
    //PixelBlitz obj_main = new PixelBlitz();
    private final soundApi obj_sound = new soundApi();
    private final menu_bar menu_bar_obj = new menu_bar();
    private final game_one gameOne_obj = new game_one();
    private final game_two gameTwo_obj = new game_two();
    public AnchorPane TitleScreen;
    public MenuBar menub;
    public MenuItem forceExit_id;
    public Button pbutton;
    public Button pexit;
    //private Med mediaView;
    game_three gameThree_obj = new game_three();

    @FXML
    //private AnchorPane TitleScreen;
    public  Stage stage;

    public void setStage(Stage stage) {

        this.stage = stage;
    }

    @FXML
    void exit_f(ActionEvent event) {
        obj_sound.play_game_selection_screen_sound();
        System.out.println("Exiting Application Success!" + event );
        // Properly close the application
//        stage.close();
        Platform.exit();
    }

    @FXML
    void switch_to_game_select(ActionEvent event) {
        obj_sound.play_game_selection_screen_sound();
        System.out.println("Play Button Clicked" + event );
        obj_sound.play_game_selection_screen_sound();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game_selection_screen.fxml"));
            Parent gameSelectionRoot = fxmlLoader.load();

            // Set the content of the stage's scene to the game selection root
            stage.getScene().setRoot(gameSelectionRoot);

        } catch (IOException e) {
            System.out.println("Something went wrong loading game_selection_screen.fxml: " + e.getMessage());
        }
    }

    @FXML

//    void switchBackToTitleScene(ActionEvent event) {
//        go_back();
//    }


    public void game_one_clicked(ActionEvent event){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("Game One!" + event);
        gameOne_obj.game_one_event();
        obj_sound.game_one_sound();
        // Add logic for game one actions
    }

    public void game_two_clicked(ActionEvent event){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("Game Two!" + event );
        gameTwo_obj.game_two_event();
        // Add logic for game two actions
    }

    public void game_three_clicked(ActionEvent event){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("Game Three!"+event );
        gameThree_obj.game_three_event();

        // Add logic for game three actions
    }
    public void documentation_clicked(ActionEvent e){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("documentation_clicked!"+e );
        menu_bar_obj.documentation_event(stage);

    }
    public void reference_clicked(ActionEvent e){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("reference_clicked!"+e);
        obj_sound.references_screen_sound();
        menu_bar_obj.references_event(stage);

    }
    public void credits_clicked(ActionEvent e){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("credits_clicked!"+e);
        obj_sound.credit_screen_sound();
        menu_bar_obj.credits_event(stage);

    }
    public void license_clicked_test_function(ActionEvent e){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("license_clicked from test function()!"+e );
        menu_bar_obj.license_event(stage);
        if (stage == null){
            System.out.println("Stage is null ");
        }
        else{
            System.out.println("stage is not null!");
        }


    }
    public void faq_clicked(){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("FAQ_clicked!");
        menu_bar_obj.faq_event(stage);
    }
    public void force_exitClicked(){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("force_exit_clicked!");
        menu_bar_obj.force_exit_event();
    }
    public void mute_audioClicked(){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("mute_audio_clicked!");
        menu_bar_obj.mute_audio_event();
    }
    public void termsAndConditionsClicked(){
        obj_sound.play_game_selection_screen_sound();
        System.out.println("Terms and Conditions Clicked");
        menu_bar_obj.termsAndConditionsEvent(stage);

    }
    public void easter_egg_clicked(){
        obj_sound.easterActivate_sound();
        System.out.println("Easter egg activated");
        menu_bar_obj.easter_egg_event(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

