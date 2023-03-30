package object;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class KeyObject extends SuperObject{
    public KeyObject(){
        name = "Key";
        try{
            image = ImageIO.read(new FileInputStream("res/objects/key.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
