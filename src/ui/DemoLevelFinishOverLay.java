package ui;

import gamestates.GameState;
import gamestates.Playing;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import static main.Game.*;
import static utilz.Constants.PlayerConstants.POWER_UP;

public class DemoLevelFinishOverLay {
    Playing playing;
    BufferedImage img,flex;
    BufferedImage[] flexing;
    private int imgX,imgY,imgW,imgH,anitick,aniIndex,aniSpeed=1;
    public DemoLevelFinishOverLay(Playing playing){
        this.playing=playing;
        createImg();
    }
    public void animation(){
        anitick++;
        if(anitick>=aniSpeed){
            anitick=0;
            aniIndex++;
            if(aniIndex==POWER_UP){
                aniIndex=7;
            }
        }
    }

    private void createImg() {
        flexing=new BufferedImage[POWER_UP];
        img= LoadSave.DemoWinScreen();
        flex=LoadSave.GetPowerUp();
        imgX= (int) (180.22*SCALE);
        imgY= (int) (11.11*SCALE);
        imgW= (int) (GAME_WIDTH/1.8);
        imgH=GAME_HEIGHT;
        for (int i = 0; i < POWER_UP; i++) {
            flexing[i] = flex.getSubimage(i * 256, 0, 256, 256);
        }
    }
    public void drawDWS(Graphics g){
        animation();
        g.setColor(new Color(0,0,0,120));
        g.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        g.drawImage(img,imgX,imgY,imgW,imgH,null);
        g.drawImage((Image) flexing[aniIndex], (int) (imgX-55.55*SCALE), (int) (imgY+5.55*SCALE), (int) (586.66*SCALE), (int) (586.66*SCALE),null);
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