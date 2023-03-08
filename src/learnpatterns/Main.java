package learnpatterns;

import learnpatterns.CoolGraphic;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    CoolGraphic.createScene();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

