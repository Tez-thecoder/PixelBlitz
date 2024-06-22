package com.example.fxml_manual;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseChecker implements MouseListener {
    GamePanelOne panel;
    public MouseChecker(GamePanelOne panel){
        this.panel=panel;

    }
    @Override
    public void mouseClicked(MouseEvent me) {
        panel.mouseClicked(me);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
