package learnpatterns;

import learnpatterns.DrawingFigures.*;
import learnpatterns.DrawingFigures.DrawingObjectTemplate.Ball;
import learnpatterns.DrawingFigures.DrawingObjectTemplate.Rectangle;
import learnpatterns.DrawingFigures.DrawingObjectTemplate.Star;
import learnpatterns.Emoticon.Eye;
import learnpatterns.Emoticon.Mouth;
import learnpatterns.Emoticon.Nose;
import learnpatterns.Emoticon.TestActionListener;
import learnpatterns.Session.SceneContext;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CoolGraphic extends JFrame {
    public void drawEmoticon()
    {
        JFrame frame = new JFrame("Emoticon by Mikola");
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

    public void drawStudent()
    {
        JFrame frame = new JFrame("Student by Mikola");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 700));
        SceneContext sceneContext = new SceneContext(500,700,0,0,500,700);
        JButton jButtonTerm = new JButton("Term");
        jButtonTerm.addActionListener(e -> sceneContext.setStateTerm());
        JButton jButtonSession = new JButton("Session");
        jButtonSession.addActionListener(e -> sceneContext.setStateSession());
        JButton jButtonHolidays = new JButton("Holidays");
        jButtonHolidays.addActionListener(e -> sceneContext.setStateHolidays());
        sceneContext.repaint();
        MouseListener panelObserver = new TestActionListener();
        JPanel jpanel = new JPanel(new FlowLayout());
        jpanel.setBackground(Color.WHITE);
        jpanel.add(jButtonTerm);
        jpanel.add(jButtonSession);
        jpanel.add(jButtonHolidays);
        jpanel.add(sceneContext);
        jpanel.revalidate();
        jpanel.repaint();
        frame.add(jpanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }


    public void drawBall() throws IOException {
        DrawingScene ds = new DrawingScene();
        ds.draw();
        JButton jButtonTerm = new JButton("Start");
        jButtonTerm.addActionListener(e -> {
            try {
                ds.addDrawingObject(new Star(20,20,250,250,3,10,900,700,0.2,0.98));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        JButton jButtonTerm1 = new JButton("Stop");
        jButtonTerm1.addActionListener(e -> System.exit(0));
        JFrame frame = new JFrame("Ball by Mikola");
        JPanel jpanel = new JPanel(new FlowLayout());
        jpanel.add(ds);
        jpanel.add(jButtonTerm);
        jpanel.add(jButtonTerm1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(jpanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }


    public static void createScene() throws IOException {
        CoolGraphic student = new CoolGraphic();
        student.drawBall();
    }
}

