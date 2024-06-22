package com.example.fxml_manual;


import javax.swing.*;
import java.awt.*;

abstract class game_one_i{
    abstract void game_one_event();
}

class game_one extends game_one_i{
    public void game_one_event() {
        //JFrame frame = new JFrame();
        System.out.println("Initializing Game one");
        //Game One Implemented here
        main_fun_g1();

    }
    public void main_fun_g1(){
        MainFrameOne frame = new MainFrameOne();
        frame.setSize(1000,1000);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)(screenSize.getWidth()/2-frame.getSize().getWidth()/2),(int)(screenSize.getHeight()/2-frame.getHeight()/2));
        frame.setResizable(false);
        frame.setTitle("Platformer Game");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}

