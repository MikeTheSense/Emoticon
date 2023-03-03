package learnpatterns.Session;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentOnTerm implements StudentState {
    private Image image;
    public StudentOnTerm(){
        try {
            image = ImageIO.read(new FileInputStream("src/Resources/studentOnTerm.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Image getImage(){return image;}
}
