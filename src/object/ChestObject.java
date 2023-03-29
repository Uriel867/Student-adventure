package object;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class ChestObject extends SuperObject{
    public ChestObject(){
        name = "Chest";
        try{
            image = ImageIO.read(new FileInputStream("res/objects/chest.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
