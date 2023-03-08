package learnpatterns.DrawingFigures;

import learnpatterns.DrawingFigures.DrawingObjectTemplate.DrawingObjectTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DrawingScene extends JComponent {
    private static final long serialVersionUID = 1L;
    private static final int PREF_W = 900;
    private static final int PREF_H = 700;
    private static final int TIMER_DELAY = 5;


    private ArrayList<DrawingObjectTemplate> drawingObjects = new ArrayList<>();
    public void addDrawingObject(DrawingObjectTemplate drawingObjectTemplate)
    {
        drawingObjects.add(drawingObjectTemplate);
    }
    public DrawingScene() {
    }
    public void draw()
    {
        new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actEvt) {
                repaint();
            }
        }).start();
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (DrawingObjectTemplate drawingObject : drawingObjects)
        {
            drawingObject.move();
            g.drawImage(drawingObject.getImage(),(int)drawingObject.getX(),(int)drawingObject.getY(),drawingObject.getHeight(),drawingObject.getWeight(),null);
        }
        g.setColor(Color.RED);
        g.drawRect(0,0,899,699);
    }
}
