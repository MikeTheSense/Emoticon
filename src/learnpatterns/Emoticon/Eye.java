package learnpatterns.Emoticon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Eye extends JComponent  {
    private  int PREF_W = 70;
    private  int PREF_H = 70;


    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isClicked=false;
    private boolean isChanged=false;
    private Image image;
    private Image changedImage;



    public Eye(int x, int y, int width, int height,int pref_w, int pref_h, Image image, Image changedImage) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.PREF_H = pref_h;
        this.PREF_W = pref_w;
        this.image = image;
        this.changedImage = changedImage;
    }
    @Override
    public void repaint(int x, int y, int z, int l)
    {
        System.out.println(x);

        if ((x > this.x) && (x< this.x + width) && (y> this.y) && (y<this.y +height)) {
            isClicked = true;
            paintComponent(this.getGraphics());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        if (isClicked) {
            if(isChanged)
            {
                g2.drawImage(image,x,y,width,height,null);
                isChanged = false;
            }
            else
            {
                g2.drawImage(changedImage,x,y,width,height,null);
                isChanged = true;
            }
        }
        else g2.drawImage(image,x,y,width,height,null);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }
}
