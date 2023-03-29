package object;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class DoorObject extends SuperObject {
    public DoorObject(){
        name = "Door";
        try{
            image = ImageIO.read(new FileInputStream("res/objects/door.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
