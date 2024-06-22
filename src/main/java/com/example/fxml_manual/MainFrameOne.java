package com.example.fxml_manual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainFrameOne extends javax.swing.JFrame {
    public MainFrameOne() {
        GamePanelOne panel = new GamePanelOne();
        panel.setLocation(0, 0);
        panel.setSize(this.getSize());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setVisible(true);
        this.add(panel);

        addKeyListener(new KeyChecker(panel));
        addMouseListener(new MouseChecker(panel));
    }



}