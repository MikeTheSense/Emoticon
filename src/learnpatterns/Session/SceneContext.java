package learnpatterns.Session;

import javax.swing.*;
import java.awt.*;

public class SceneContext extends JComponent {
    private  int PREF_W = 70;
    private  int PREF_H = 70;
    private int x;
    private int y;
    private int width;
    private int height;
    private StudentState state = new StudentOnTerm();

    public SceneContext(int PREF_W, int PREF_H, int x, int y, int width, int height) {
        this.PREF_W = PREF_W;
        this.PREF_H = PREF_H;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setStateSession(){
        state = new StudentOnSession();
        repaint();
    }
    public void setStateHolidays(){
        state = new StudentOnHolidays();
        repaint();
    }
    public void setStateTerm(){
        state = new StudentOnTerm();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.drawImage(state.getImage(),x,y,width,height,null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }
}
