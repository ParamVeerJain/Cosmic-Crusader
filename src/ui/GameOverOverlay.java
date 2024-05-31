package ui;

import gamestates.GameState;
import gamestates.Playing;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import static main.Game.*;

public class GameOverOverlay {
    Playing playing;
    private BufferedImage img;
    private int imgX,imgY,imgW,imgH;
    public GameOverOverlay(Playing playing){
        this.playing=playing;
        createImg();
    }

    private void createImg() {
        img= LoadSave.GetGameOverScreen();
        imgX= (int) (222.22*SCALE);
        imgY= (int) (11.11*SCALE);
        imgW=GAME_WIDTH/2;
        imgH=GAME_HEIGHT;
    }

    public void drawG(Graphics g){
        g.setColor(new Color(0,0,0,150));
        g.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);

//        g.setColor(Color.WHITE);
//        g.drawString();
        g.drawImage(img,imgX,imgY,imgW,imgH,null);
    }
    public void KeyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            playing.resetAll();
            GameState.state=GameState.MENU;
        } else if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }
}
