package learnpatterns;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Emoticon extends JFrame {
    public static void createScene()
    {
        JFrame frame = new JFrame("CrossRoadFacade by Mikola");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 700));
        Image nose = null;
        Image tochedNose = null;
        Image leftEye = null;
        Image leftClosedEye = null;
        Image rightEye = null;
        Image rightClosedEye = null;
        Image mounth = null;
        Image openedMounth = null;
        try {
            leftEye = ImageIO.read(new FileInputStream("src/Resources/leftopenedeye.png"));
            leftClosedEye = ImageIO.read(new FileInputStream("src/Resources/leftclosedeye.png"));
            rightEye = ImageIO.read(new FileInputStream("src/Resources/rightopenedeye.png"));
            rightClosedEye = ImageIO.read(new FileInputStream("src/Resources/rightclosedeye.png"));
             nose = ImageIO.read(new FileInputStream("src/Resources/1f443.png"));
             tochedNose = ImageIO.read(new FileInputStream("src/Resources/c2eb5b820a7aa96b87090460a815033f.png"));
             mounth = ImageIO.read(new FileInputStream("src/Resources/smile.jpg"));
             openedMounth = ImageIO.read(new FileInputStream("src/Resources/unsmile.jpg"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Eye eyeLeft = new Eye(50,10,300,200,400,200,leftEye,leftClosedEye);
        Eye eyeRight = new Eye(50,10,300,200,400,200,rightEye,rightClosedEye);
        Nose noseC = new Nose(125,50,150,150,400,200,nose,tochedNose);
        Mouth mountC = new Mouth(175,50,250,150,600,200,mounth,openedMounth);
        MouseListener panelObserver = new TestActionListener();
       // eyeLeft.addMouseListener();
        eyeLeft.addMouseListener(panelObserver);
        eyeRight.addMouseListener(panelObserver);
        noseC.addMouseListener(panelObserver);
        mountC.addMouseListener(panelObserver);
        JPanel jpanel = new JPanel(new FlowLayout());
        jpanel.setBackground(Color.WHITE);
        jpanel.add(eyeLeft);
        jpanel.add(eyeRight);
        jpanel.add(noseC);
        jpanel.add(mountC);
        jpanel.revalidate();
        jpanel.repaint();
        frame.add(jpanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}

