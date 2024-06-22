package com.example.fxml_manual;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyChecker extends KeyAdapter{
    GamePanelOne panel;
    public KeyChecker(GamePanelOne panel){
        this.panel = panel;

    }
    @Override
    public void keyPressed(KeyEvent e){
        panel.keyPressed(e);

    }
    @Override
    public void keyReleased(KeyEvent e){
        panel.keyReleased(e);
    }
}
