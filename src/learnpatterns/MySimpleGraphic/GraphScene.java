package learnpatterns.MySimpleGraphic;


import learnpatterns.DrawingFigures.DrawingObjectTemplate.DrawingObjectTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GraphScene extends JComponent {
    private static final int PREF_W = 900;
    private static final int PREF_H = 700;
    private Double[] arrayX=new Double[0];
    private Double[] arrayY=new Double[0];
    private final double stepy = 10;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int ox = PREF_W/2;
        int oy = PREF_H/2;
        g.setColor(Color.RED);

        int k =0;
        while (k<arrayX.length&&arrayX[k]<0)
        {
            k++;
        }
        if (k<arrayX.length-1&&k!=0)
        {
            Double[] arrayXLessZero = Arrays.copyOf(arrayX,k);
            Double[] arrayYLessZero = Arrays.copyOf(arrayY,k);
            Double[] arrayXAboveZero = new Double[arrayX.length-k];
            System.arraycopy( arrayX, k, arrayXAboveZero, 0, arrayX.length-k);
            Double[] arrayYAboveZero = new Double[arrayY.length-k];
            System.arraycopy( arrayY, k, arrayYAboveZero, 0, arrayY.length-k);
            for (int i = 0; i<arrayXAboveZero.length-1;i++) {
                g.drawLine(
                        arrayXAboveZero[i].intValue() + (ox),
                        -arrayYAboveZero[i].intValue() + (oy),
                        arrayXAboveZero[i + 1].intValue() + (ox),
                        -arrayYAboveZero[i + 1].intValue() + (oy)
                );
            }
            for (int i = 0; i<arrayXLessZero.length-1;i++) {
                g.drawLine(
                        arrayXLessZero[i].intValue() + (ox),
                        -arrayYLessZero[i].intValue() + (oy),
                        arrayXLessZero[i + 1].intValue() + (ox),
                        -arrayYLessZero[i + 1].intValue() + (oy)
                );
            }
        }
        else {

            for (int i = 0; i < arrayX.length - 1; i++) {
                g.drawLine(
                        arrayX[i].intValue() + (ox),
                        -arrayY[i].intValue() + (oy),
                        arrayX[i + 1].intValue() + (ox),
                        -arrayY[i + 1].intValue() + (oy)
                );
            }
        }


        g.setColor(Color.BLACK);
        //double stepy = 10;
        g.drawLine(0, oy, PREF_W , oy );
        g.drawLine(ox , 0 , ox , PREF_H );
        for(int i = 0; i < PREF_W/stepy; i++){
            g.drawLine(
                    ox-2,
                    (int)(i * stepy),
                    ox+2,
                    (int)(i * stepy));
        }
        for(int i = 0; i <PREF_W/stepy; i++){
            g.drawLine(
                    (int)(i * stepy) ,
                    oy-2  ,
                    (int)(i * stepy) ,
                    oy+2 );
        }
    }
    public void draw(DataSet ds)
    {
        HashMap<Double,Double> points = ds.getPoints();
        HashMap<Double,Double> sorted = points.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        arrayX = new Double[points.size()];
        arrayY = new Double[points.size()];
        int i = 0;
        for (Map.Entry<Double,Double> point : sorted.entrySet())
        {
            arrayX[i] = point.getKey()*stepy;
            arrayY[i] = point.getValue()*stepy;
            i++;
        }
        repaint();
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }
}
