package learnpatterns.DrawingFigures.DrawingObjectTemplate;

import java.awt.*;

public abstract class DrawingObjectTemplate {
    protected int height=20;
    protected int weight=20;
    protected double gravity=0.2;
    protected Image image;
    protected double x=30;
    protected double y=30;
    protected double dx=3;
    protected double dy=3;
    protected int xborder=900;
    protected int yborder=700;
    protected double l;

    public DrawingObjectTemplate(int height, int weight, int xStartPosition, int yStartPosition, int dx, int dy, int xborder, int yborder,double gravity,double l,Image image) {
        this.height = height;
        this.weight = weight;
        this.gravity = gravity;
        this.image = image;
        this.x = xStartPosition;
        this.y = yStartPosition;
        this.dx = dx;
        this.dy = dy;
        this.xborder = xborder;
        this.yborder = yborder;
        this.l=l;
    }
    protected DrawingObjectTemplate() {
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public int getHeight() {
        return height;
    }
    public int getWeight() {
        return weight;
    }
    public Image getImage() {
        return image;
    }
    public void move()
    {
        if (x > (xborder-weight) || x < 0)
        {
            dx=-dx;
            x+=dx;
        }
        if (y > (yborder-height) || y <height)
        {
            dy=-dy*0.9665;
            y+=dy;
        }
        x+=dx;
        y+=dy;
        dy+=gravity;
    };
}
