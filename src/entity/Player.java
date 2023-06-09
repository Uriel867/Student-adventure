package entity;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        // middle of the screen
        screenX = gp.SCREEN_WIDTH / 2 - (gp.TILE_SIZE / 2);
        screenY = gp.SCREEN_HEIGHT / 2 - (gp.TILE_SIZE / 2);
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = gp.TILE_SIZE * 23;
        worldY = gp.TILE_SIZE * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(new FileInputStream("res/player/up1.png"));
            up2 = ImageIO.read(new FileInputStream("res/player/up2.png"));
            down1 = ImageIO.read(new FileInputStream("res/player/down1.png"));
            down2 = ImageIO.read(new FileInputStream("res/player/down2.png"));
            right1 = ImageIO.read(new FileInputStream("res/player/right1.png"));
            right2 = ImageIO.read(new FileInputStream("res/player/right2.png"));
            left1 = ImageIO.read(new FileInputStream("res/player/left1.png"));
            left2 = ImageIO.read(new FileInputStream("res/player/left2.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyH.upPressed || keyH.downPressed || keyH.rightPressed || keyH.leftPressed){
            if(keyH.upPressed) {
                direction = "up";
                worldY -= speed;
            }

            else if(keyH.downPressed) {
                direction = "down";
                worldY += speed;
            }

            else if(keyH.leftPressed) {
                direction = "left";
                worldX -= speed;
            }
            else if(keyH.rightPressed) {
                direction = "right";
                worldX += speed;
            }
            spriteCounter++;
            if(spriteCounter > 15){
                if(spriteNum == 1)
                    spriteNum = 2;
                else if(spriteNum == 2)
                    spriteNum = 1;
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;
        switch(direction){
            case "up":
                if(spriteNum == 1)
                    image = up1;
                if(spriteNum == 2)
                    image = up2;
                break;
            case "down":
                if(spriteNum == 1)
                    image = down1;
                if(spriteNum == 2)
                    image = down2;
                break;
            case "left":
                if(spriteNum == 1)
                    image = left1;
                if(spriteNum == 2)
                    image = left2;
                break;
            case "right":
                if(spriteNum == 1)
                    image = right1;
                if(spriteNum == 2)
                    image = right2;
                break;
        }
        g2.drawImage(image,screenX,screenY,gp.TILE_SIZE, gp.TILE_SIZE, null);

    }
}
