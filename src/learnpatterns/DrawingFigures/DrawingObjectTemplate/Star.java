package learnpatterns.DrawingFigures.DrawingObjectTemplate;

import learnpatterns.DrawingFigures.DrawingObjectTemplate.DrawingObjectTemplate;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Star extends DrawingObjectTemplate {
    public Star(int height, int weight, int xStartPosition, int yStartPosition, int dx, int dy, int xborder, int yborder, double gravity, double l) throws IOException {
        super(height, weight, xStartPosition, yStartPosition, dx, dy, xborder, yborder, gravity, l, ImageIO.read(new File("src/Resources/star.png")));
    }
}
