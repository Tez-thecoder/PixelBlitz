package com.example.fxml_manual;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanelOne extends javax.swing.JPanel implements ActionListener {
    PlayerOne player;
    int cameraX;
    ArrayList<Wall>walls = new ArrayList<>();
    Timer gameTimer;
    Rectangle restartRect;
    Rectangle homeRect;
    int offset;
    private Image backgroundImage;
    public Font buttonFont = new Font("Arial",Font.BOLD,30);

    public GamePanelOne(){
        /*Exit Code Start*/
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point clickedPoint = e.getPoint();

                // Check if the click was within the home button bounds
                if (homeRect.contains(clickedPoint)) {
                    exitApplication(); // Call the method to exit the application
                } else if (restartRect.contains(clickedPoint)) {
                    reset(); // Call the method to reset the game
                }
            }
        });

        /*Exit Code End */
        restartRect = new Rectangle(550,25,50,50);
        homeRect = new Rectangle(625, 25, 50, 50);

;

        //
        try {
            // Load the background image
            backgroundImage = ImageIO.read(new File("D:\\Coding\\P4\\PixelBlitz_v1.1-main (1)\\PixelBlitz_v1.1-main\\pixelBlitzProject\\GImages\\sky2.jpg")); // Replace with your image file path
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Failed to Load Background Image"+e);
        }
        //

        player = new PlayerOne(400,300,this);

        reset();

//        makeWalls(50);

        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {

                if(walls.get(walls.size()-1).x<800){
                    offset+=700;
                    System.out.println("Size of wall"+ walls.size());
                    makeWalls(offset);

                }

                player.set();
                for (Wall wall:walls) wall.set(cameraX);

                for(int i =0;i< walls.size();i++){
                    if(walls.get(i).x<-800)walls.remove(i);
                }

                repaint();

            }
        },0,17);

    }
    //paint component
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image if it's loaded
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    //
    public void reset(){
        player.x=200;
        player.y=0;
        cameraX=150;
        player.x_speed=0;
        player.y_speed=0;
        offset = -150;
        makeWalls(offset);
    }
    /*Generate Walls method start*/
    public void makeWalls(int offset){
        int s=50;
        Random rand = new Random();
        int index=rand.nextInt(4);
        if(index == 0){
            for(int i=0;i<14;i++)walls.add(new Wall(Color.PINK,offset+i*50,600,s,s));
        }
        else if(index == 1){
            for(int i=0;i<5;i++)walls.add(new Wall(Color.WHITE,offset+i*50,600,s,s));
            walls.add(new Wall(Color.WHITE,offset+500,600,s,s));
            walls.add(new Wall(Color.WHITE,offset+550,600,s,s));
            walls.add(new Wall(Color.WHITE,offset+600,600,s,s));
            walls.add(new Wall(Color.WHITE,offset+650,600,s,s));
            walls.add(new Wall(Color.WHITE,offset+700,600,s,s));
            walls.add(new Wall(Color.WHITE,offset+750,600,s,s));

        }
        else if(index==2){
            for(int i=0;i<14;i++)walls.add(new Wall(Color.GREEN,offset+i*50,600,s,s));
            for(int i=0;i<12;i++)walls.add(new Wall(Color.GREEN,offset+50+i*50,550,s,s));
            for(int i=0;i<10;i++)walls.add(new Wall(Color.GREEN,offset+100+i*50,500,s,s));
            for(int i=0;i<10;i++)walls.add(new Wall(Color.GREEN,offset+150+i*50,450,s,s));
            for(int i=0;i<10;i++)walls.add(new Wall(Color.GREEN,offset+200+i*50,400,s,s));


        }
        else {
            for(int i=0;i<3;i++)walls.add(new Wall(Color.BLUE,offset+i*50,600,s,s));
            for(int i=0;i<2;i++)walls.add(new Wall(Color.BLUE,offset+50+i*50,550,s,s));
            walls.add(new Wall(Color.WHITE,offset+450,500,s,s));
            walls.add(new Wall(Color.WHITE,offset+300,500,s,s));
            walls.add(new Wall(Color.WHITE,offset+550,500,s,s));

        }

    }
    public void paint(Graphics g){
        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;

        player.draw(gtd);

        for(Wall wall:walls)wall.draw((gtd));
        gtd.setColor(Color.BLACK);
        gtd.drawRect(550,25,50,50);
        gtd.drawRect(620,25,50,50);
        gtd.setColor(Color.WHITE);
        gtd.fillRect(551,26,48,48);
        gtd.setColor(Color.BLACK);
        gtd.setFont(buttonFont);
        gtd.drawString("R",564,60);
        gtd.drawString("E",639,60);


    }
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()=='a') player.KeyLeft = true;
        if(e.getKeyChar()=='w') player.KeyUp = true;
        if(e.getKeyChar()=='s') player.KeyDown = true;
        if(e.getKeyChar()=='d') player.KeyRight = true;
        if(e.getKeyChar()=='r')reset();
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar()=='a') player.KeyLeft = false;
        if(e.getKeyChar()=='w') player.KeyUp = false;
        if(e.getKeyChar()=='s') player.KeyDown = false;
        if(e.getKeyChar()=='d') player.KeyRight = false;
    }
    @Override
    public void actionPerformed(ActionEvent ae){

    }

    public void mouseClicked(MouseEvent me) {
        if(restartRect.contains(new Point(me.getPoint().x ,me.getPoint().y-27)))reset();

    }
    /*Exit Method Start*/
    private void exitApplication() {
        int confirmed = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to exit the application?", "Exit Confirmation",
                JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                // Perform any cleanup or saving operations if needed before exiting
                System.exit(0);
            }

        /*Exit Method End*/
    }
    public Color getRandomColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
}
