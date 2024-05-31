package Entities;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Arrays;

import static main.Game.GAME_WIDTH;
import static main.Game.SCALE;

public class Fireball extends Entity{
    private int count;
    public int dx,fireBallWidth=212,fireBallHeight=240,initialX,initialY;
    public float fireballspeed;
    public boolean hit=false;
    public boolean remove;
    public static boolean hasPlayedOnce;
    private BufferedImage[] fireballSprites=new BufferedImage[6];
    private BufferedImage[] fireballSpritesR=new BufferedImage[6];
    public BufferedImage fireball=LoadSave.GetLevelFBS(),fireballL=LoadSave.GetLevelFBSLEFT();
    private int fireanitick,fireaniRindex,firefpsspeed=3,fireindex=6;
    protected int widthToDraw,heightToDraw;
    public static boolean fireBallDir;
    private float width,height;
    Herolvl1 herolvl1;
    EnemyManager enemyManager;
    public Fireball(EnemyManager enemyManager){
        this.enemyManager=enemyManager;
    }
    public Fireball(int x, int y,boolean isFacingRight) {
        super((float) (x+(5.555*SCALE)),y,(int) (66.67*SCALE),(int) (66.67*SCALE),62);
//        this.herolvl1=herolvl1;
//        initFireBallHitBox();
        initialX=x;
        fireaniRindex=0;
        initialY= (int) (y+(11.11*SCALE));
        width=212;
        height=240;
        widthToDraw=heightToDraw= (int) (66.67*SCALE);
        fireballspeed = (float) ((((8*SCALE)-SCALE)+SCALE)*(SCALE/3*SCALE));
//        fireball = LoadSave.GetLevelFBS();
//        fireballL = LoadSave.GetLevelFBSL();
        for(int i=0;i<fireballSprites.length;i++){
            fireballSpritesR[i]=fireball.getSubimage(i*240,0,240,240);
        }
//        setFireBallAttributes();
//        fireBallAnimations();
        hit=false;
    }

//    private void setFireBallAttributes() {
//        for(int i=0;i<fireballSprites.length;i++){
//            fireballSprites[i]=fireballSpritesL[i];
//        }
//        for(int i=0;i<fireballSprites.length;i++){
//            fireballSprites[i]=fireballSpritesL[i];
//        }
//    }


    public void updateFireballPos(){
          fireBallAnimations();
           hitBoxFireBall.x += (int) fireballspeed;
    }
    private void fireBallAnimations(){
        hasPlayedOnce=false;
        fireanitick++;
        if (fireanitick >= firefpsspeed) {
            fireanitick = 0;
           fireaniRindex++;
           if(fireaniRindex>=fireindex){
               fireaniRindex=0;
               hasPlayedOnce=true;
               Herolvl1.setFireTheBall(false);
           }
    }
    }
    public static boolean getHasPlayedOnce(){
        return hasPlayedOnce;
    }
    public void setHit(){
        hit=true;
    }




    public boolean shouldRemove(){
        return remove;
    }
    public void fireBallRender(Graphics g){
        hit=false;
//        System.out.println("HfbY="+hitBoxFireBall.y);
//        System.out.println("HBB="+hitBoxBoss.y);
//        System.out.println((int) (hitBoxFireBall.y+(20.777*SCALE)));
        updateFireballPos();
//        if((hitBoxFireBall.x<=GAME_WIDTH) || (hitBoxFireBall.x<=(hitBoxBoss.x))) {
           g.drawImage(fireballSpritesR[fireaniRindex], hitBoxFireBall.x, hitBoxFireBall.y, widthToDraw, heightToDraw, null);
//            if(((hitBoxFireBall.x<=hitBoxBoss.x)||(hitBoxFireBall.x>=(hitBoxBoss.x+(hitBoxBoss.width/2))))) {
//                if(!hit) {
//                    drawFireBallHitBox(g);
//                }
//            }
            if(((hitBoxFireBall.x>=(hitBoxBoss.x))&&(hitBoxFireBall.x<=(hitBoxBoss.x+(hitBoxBoss.width/2))))&&((int) (hitBoxFireBall.y+(20.777*SCALE))>=hitBoxBoss.y)  && !EnemyManager.isBossHasDiedNow()) {
                Arrays.fill(fireballSpritesR, null);
                EnemyManager.setFlinching(true);
//                enemyManager.changeBossHealth(-2);
//                for(int i=0;i<fireballSpritesR.length;i++){
//                    if(fireballSpritesR[i]==null){
//                        i++;
//                    }
//                    if(i==fireballSpritesR.length-1){
                        if(count==0){
                            setHit();
                            EnemyManager.changeBossHealth(-5);
                            count++;
                        }
//                        break;
//                    }
//                }
            }

//        }

    }
}
