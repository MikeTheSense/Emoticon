package learnpatterns.DrawingFigures.DrawingObjectTemplate;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Rectangle extends DrawingObjectTemplate {
    public Rectangle(int height, int weight, int xStartPosition, int yStartPosition, int dx, int dy, int xborder, int yborder, double gravity, double l) throws IOException {
        super(height, weight, xStartPosition, yStartPosition, dx, dy, xborder, yborder, gravity, l, ImageIO.read(new File("src/Resources/rectangle.png")));
    }
    public void move() {
        if (x > (xborder - weight) || x < 0) {
            dx = -dx;
            x += dx;
        }
        if (y > (yborder - height) || y < 0) {
            dy = -dy * 0.95;
            y += dy;
        }
        x += dx;
        y += dy;
        dy += gravity;
    }
}

