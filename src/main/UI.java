package main;

import object.KeyObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Font arial_40;
    BufferedImage keyImage;

    public boolean messageOn = false;
    public String message = "";

    int messageCounter = 0;
    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial",Font.PLAIN,40);
        KeyObject key = new KeyObject();
        keyImage = key.image;
    }

    public void draw(Graphics2D g2){
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        g2.drawImage(keyImage,gp.TILE_SIZE / 2, gp.TILE_SIZE / 2,gp.TILE_SIZE,gp.TILE_SIZE,null);
        g2.drawString("x =" +gp.player.hasKey,74,65);

        if(messageOn){
            g2.drawString(message,gp.TILE_SIZE / 2,gp.TILE_SIZE * 5);
            messageCounter++;
            // hit 120 frames which is 2 seconds and delete the message
            if(messageCounter > 120){
                messageCounter = 0;
                messageOn = false;
            }
        }
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }
}
