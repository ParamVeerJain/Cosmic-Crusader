package main;

import gamestates.GameMenu;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameWindow {
    private JFrame jframe;
    public GameWindow(GamePanel gamePanel){
        jframe = new JFrame();
      //  jframe.setSize(400,200);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.pack();     //fits the preferred size to window size
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);
//        jframe.addWindowFocusListener(new WindowFocusListener() {
//            @Override
//            public void windowGainedFocus(WindowEvent e) {
//
//            }
//
//            @Override
//            public void windowLostFocus(WindowEvent e) {
//                 gamePanel.getGame().windowFocusLost();
//            }
//        });
    }
}
