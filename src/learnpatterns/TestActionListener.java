package learnpatterns;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

   public class TestActionListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
             e.getComponent().repaint(e.getX(),e.getY(),0,0);
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

