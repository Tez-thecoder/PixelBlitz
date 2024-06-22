package com.example.fxml_manual;

import java.awt.*;
import java.awt.Rectangle;

public class PlayerOne {
    int x;
    int y;
    int width;
    int height;
    //horizontal velocity
    double x_speed;
    //vertical velocity
    double y_speed;
    Rectangle hitBox;

    boolean KeyLeft;
    boolean KeyRight;
    boolean KeyUp;
    boolean KeyDown;
    GamePanelOne panel;
    public PlayerOne(int x,int y,GamePanelOne panel){
        this.panel = panel;
        this.x = x;
        this.y = y;

        width=50;
        height=100;
        hitBox = new Rectangle(x,y,width,height);

    }
    public void set(){
        if(KeyLeft && KeyRight || !KeyRight && !KeyLeft) x_speed*=0.8;
        else if(KeyLeft && ! KeyRight) x_speed --;
        else if(KeyRight && ! KeyLeft) x_speed ++;

        if(x_speed >0 && x_speed<0.75) x_speed=0;
        if(x_speed <0 && x_speed>0.75) x_speed=0;

        if(x_speed > 7)x_speed = 7;
        if(x_speed<-7) x_speed = -7;

        if(KeyUp){
            hitBox.y ++;
            for (Wall wall:panel.walls){
                //Jump_further
                if(wall.hitBox.intersects(hitBox)) y_speed=-14;
            }
            hitBox.y --;
//
        }
        y_speed+=0.5;

        //Horizontal Collisions
        hitBox.x +=x_speed;
        for(Wall wall: panel.walls){
            if (hitBox.intersects(wall.hitBox)){
                hitBox.x -= x_speed;
                while(!wall.hitBox.intersects(hitBox)) hitBox.x +=Math.signum(x_speed);
                hitBox.x -= Math.signum(x_speed);
                panel.cameraX+=x-hitBox.x;
                x_speed=0;
                hitBox.x=x;

            }
        }

        //Vertical Collisions
        hitBox.y +=y_speed;
        for(Wall wall: panel.walls){
            if (hitBox.intersects(wall.hitBox)){
                hitBox.y -= y_speed;
                while(!wall.hitBox.intersects(hitBox)) hitBox.y +=Math.signum(y_speed);
                hitBox.y -= Math.signum(y_speed);
                y_speed=0;
                y=hitBox.y;
            }
        }


        panel.cameraX-=x_speed;
        y+=y_speed;

        hitBox.x = x;
        hitBox.y = y;

        //death code
        if (y>1000)panel.reset();

    }
    public void draw(Graphics2D gtd){
        gtd.setColor(Color.BLACK);
        gtd.fillRect(x,y,width,height);
        Font f = new Font("Arial",Font.BOLD,40);
        gtd.setFont(f);
        gtd.drawString(Integer.toString(x),100,100);

    }
    public void score(Graphics2D gtd){
        Font f = new Font("Serif",Font.BOLD,50);
        gtd.setFont(f);
        gtd.drawString(Integer.toString(x),100,100);
    }
}
