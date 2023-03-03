package learnpatterns.Session;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentOnSession implements StudentState {
    private Image image;
    public StudentOnSession(){
        try {
            image = ImageIO.read(new FileInputStream("src/Resources/studentOnSession.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Image getImage(){return image;}
}
