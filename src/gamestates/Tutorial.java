package gamestates;

import main.Game;
import utilz.HelpMethods;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static main.Game.*;
import static utilz.Constants.PlayerConstants.*;

public class Tutorial extends State implements StateMethods{
    private int size= (int) (426.66*SCALE);
    Font font=new Font("Serif",Font.BOLD,24);
    private BufferedImage h1run,h1fb,h1jump,bg;
    private int anitick, aniRindexR,aniRindexJ,aniRindexF, aniCindex, herofpsspeed =7;
    private BufferedImage runAni[]=new BufferedImage[26];
    private BufferedImage fbAni[]=new BufferedImage[26];
    private BufferedImage jumpAni[]=new BufferedImage[26];
    public Tutorial(Game game) {
        super(game);
        h1animatestore();
    }

    private void h1animatestore() {
       h1run= LoadSave.GetRun();
       h1fb=LoadSave.GetFireCharge();
       h1jump=LoadSave.GetJ1();
       bg=LoadSave.GetHomeScreenBG();
       FBC();
       jumpaniL();
       run();
    }
    public void FBC() {
        int j=0;
        for (int i = 19; i < fbAni.length; i++) {
            fbAni[j] = h1fb.getSubimage(i * 256, 0, 256, 256);
            j++;
        }
    }
    public void jumpaniL() {
        for (int i = 0; i < jumpAni.length; i++) {
            jumpAni[i] = h1jump.getSubimage(i * 256, 0, 256, 256);
        }
    }
    public void run() {
        for (int i = 0; i < runAni.length; i++) {
            runAni[i] = h1run.getSubimage(i * 256, 0, 256, 256);
        }
    }

    @Override
    public void update() {
        animations();
    }

    private void animations() {
        anitick++;
        if (anitick >= herofpsspeed) {
            anitick = 0;
            aniRindexR++;
            aniRindexF++;
            aniRindexJ++;
            if (aniRindexR >= RUN) {
                aniRindexR=0;
            }
            if(aniRindexJ>= J1){
              aniRindexJ=0;
            }
            if(aniRindexF>=FIREBALLCHARGE){
                aniRindexF=0;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setFont(font);
        g.drawImage(bg,0,0,GAME_WIDTH,GAME_HEIGHT,null);
        g.setColor(new Color(0,0,0,120));
        g.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        g.drawImage((Image) runAni[aniRindexR],(int)(-61.11*SCALE), (int) (61.11*SCALE),size,size,null);
        g.drawImage(jumpAni[aniRindexJ],(int)(200*SCALE),(int)(61.11*SCALE),size,size,null);
        g.drawImage((Image) fbAni[aniRindexF], (int) (450*SCALE), (int) (61.11*SCALE),size,size,null);
        g.setColor(Color.WHITE);
        g.drawString("Press \"A\" to run left ", (int) (116.66*SCALE), (int) (111.11*SCALE));
        g.drawString("and \"D\" to run right ",(int) (116.66*SCALE), (int) (125*SCALE));
        g.drawString("Press \"SPACEBAR\" to jump", (int) (333.33*SCALE), (int) (111.11*SCALE));
        g.drawString("Press \"G\" to shoot EnergyBalls", (int) (583.33*SCALE), (int) (111.11*SCALE));
        g.drawString("and hold to refill EnergyBall energy", (int) (583.33*SCALE), (int) (125*SCALE));
        g.drawString("Press ENTER to fight the Demon", (int) (333.33*SCALE), (int) (333.33*SCALE));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            GameState.state=GameState.PLAYING;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
