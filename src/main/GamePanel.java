package main;

import inputs.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static main.Game.*;
import static utilz.Constants.PlayerConstants.*;

public class GamePanel extends JPanel {
    private Game game;
//    Game game=new Game();
    private mouseinputs mouse=new mouseinputs(this); // mouseinputs object

    public GamePanel(Game game){
        this.game=game;
        setPanelSize();
        addKeyListener(new keyboardinputs(this)); //method used to get the keyboard inputs from input package
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
//        setGameE(mouse);
    }


    public void setPanelSize()
    { Dimension size=new Dimension(GAME_WIDTH,GAME_HEIGHT);
//        System.out.println("WIDTH="+GAME_WIDTH +"HEIGHT="+GAME_HEIGHT);
        setPreferredSize(size);
    }

public void updateGame()
{
//    animations();
}
public void paintComponent(Graphics g) //We never call this method, it gets called when we start the game
{
    super.paintComponent(g);
    game.render(g);
}
public Game getGame()
{
    return game;
}
}
