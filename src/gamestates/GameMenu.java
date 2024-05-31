package gamestates;

import main.Game;
import ui.MenuButton;
import utilz.LoadSave;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static main.Game.*;
import static utilz.Constants.PlayerConstants.*;

public class GameMenu extends State implements StateMethods{
    public MenuButton[] buttons=new MenuButton[2];
    public BufferedImage HomeScreenBG= LoadSave.GetHomeScreenBG(),HomeScreen=LoadSave.GetHC(),HomeScreen2=LoadSave.GetHC2();


    public GameMenu(Game game) {
        super(game);
        loadButtons();
    }

    private void loadButtons() {
        buttons[0]=new MenuButton((int) (500*SCALE), (int) (222.222*SCALE),0,GameState.TUTORIAL);
        buttons[1]=new MenuButton((int) (500*SCALE), (int) (288.88*SCALE),2,GameState.QUIT);
    }

    @Override
    public void update() {
        for (MenuButton mb : buttons){
            mb.update();
        }
    }

    @Override
    public void draw(Graphics g) {
//        g.setColor(Color.BLUE);
        g.drawImage(HomeScreenBG,0,0,GAME_WIDTH,GAME_HEIGHT,null);
        g.drawImage(HomeScreen,(int)(30.77*SCALE),(int)(33.333*SCALE),(int)(364.444*SCALE),(int)(425*SCALE),null);
        g.drawImage(HomeScreen2,(int)(380.77*SCALE),(int)(15.333*SCALE),(int)(400.444*SCALE),(int)(250*SCALE),null);
            for (MenuButton mb : buttons) {
                mb.drawButtons(g);
            }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (MenuButton mb: buttons){
            if (isIn(e,mb)){
                mb.setMousePressed(true);
                break;
            }
        }
    }

    private void resetButtons() {
        for (MenuButton mb : buttons) {
            mb.resetBools();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(MenuButton mb : buttons){
            if(isIn(e,mb)){
                if(mb.isMousePressed()){
                    mb.applyGameState();
                }
                break;
            }
        }
        resetButtons();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (MenuButton mb : buttons){
            mb.setMouseOver(false);
        }
        for (MenuButton mb : buttons){
            if(isIn(e,mb)){
                mb.setMouseOver(true);
                break;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
                  GameState.state=GameState.TUTORIAL;
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
