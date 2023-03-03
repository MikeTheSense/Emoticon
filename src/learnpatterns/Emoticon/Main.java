package learnpatterns.Emoticon;

import learnpatterns.CoolGraphic;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CoolGraphic.createScene();
            }
        });
    }
}

