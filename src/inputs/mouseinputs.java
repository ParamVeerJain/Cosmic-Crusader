package inputs;

import gamestates.GameState;
import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class mouseinputs implements MouseListener, MouseMotionListener {
    GamePanel gamePanel;
    public mouseinputs(GamePanel gamePanel){
        this.gamePanel=gamePanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
       switch (GameState.state){
//           case MENU -> {
//            gamePanel.getGame().getMenu().mouseClicked(e);
//           }
           case PLAYING -> {

           }

       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (GameState.state){
            case MENU -> {
                gamePanel.getGame().getMenu().mousePressed(e);
            }
            case PLAYING -> {

            }

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (GameState.state){
            case MENU -> {
                gamePanel.getGame().getMenu().mouseReleased(e);
            }
            case PLAYING -> {

            }

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (GameState.state){
            case MENU -> {
                gamePanel.getGame().getMenu().mouseMoved(e);
            }
            case PLAYING -> {

            }

        }

    }
}
