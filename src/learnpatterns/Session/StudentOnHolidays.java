package learnpatterns.Session;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentOnHolidays implements StudentState {
    private Image image;
    public StudentOnHolidays(){
        try {
            image = ImageIO.read(new FileInputStream("src/Resources/studentOnHolidays.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Image getImage(){return image;}
}
