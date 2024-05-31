package inputs;

import Entities.Fireball;
import Entities.Herolvl1;
import gamestates.GameState;
import main.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import  static utilz.HelpMethods.CanMoveHere;

public class keyboardinputs implements KeyListener {
private boolean isDpressed=false;
private boolean isApressed=false;
private boolean isGpressed=false;
private boolean right;

private GamePanel gamePanel;
//private Graphics g1;
public keyboardinputs(GamePanel gamePanel) //Gives gamepanel access to keyboard inputs
{
    this.gamePanel=gamePanel;
}
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (GameState.state){
            case MENU -> {
                gamePanel.getGame().getMenu().keyPressed(e);
            }
            case PLAYING -> {
                gamePanel.getGame().getPlaying().keyPressed(e);

            }
            case TUTORIAL -> {
                gamePanel.getGame().getTutorial().keyPressed(e);
            }
            default -> {
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (GameState.state){
            case MENU -> {
                gamePanel.getGame().getMenu().keyReleased(e);
            }
            case PLAYING -> {
                gamePanel.getGame().getPlaying().keyReleased(e);
            }
            default -> {
            }
        }
    }
}
