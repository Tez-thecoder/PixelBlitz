package com.example.fxml_manual;

import javafx.stage.Stage;

import javax.swing.*;

abstract class game_two_i{
    static void game_two_event() {
    }
}

class game_two extends game_two_i{

    public static void game_two_event() {
        main_fn2();


    }
    public static void main_fn2(){
        //Main Function for Game 2(start from here)
        JFrame obj = new JFrame();
        GamePlay gameplay = new GamePlay();
        obj.setBounds(10,10,700,600);
        obj.setTitle("BrickBreaker");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);
    }

}
