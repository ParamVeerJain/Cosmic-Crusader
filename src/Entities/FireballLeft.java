package Entities;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Arrays;

import static main.Game.GAME_WIDTH;
import static main.Game.SCALE;

public class FireballLeft extends Entity{
    private int count;
    public int dx,fireBallWidth=212,fireBallHeight=240,initialX,initialY;
    public float fireballspeed;
    public boolean hit=false;
    public boolean remove;
    public static boolean hasPlayedOnce;
    private BufferedImage[] fireballSprites=new BufferedImage[6];
    private BufferedImage[] fireballSpritesR=new BufferedImage[6];
    public BufferedImage fireball=LoadSave.GetLevelFBSLEFT();
    private int fireanitick,fireaniRindex,firefpsspeed=3,fireindex=6;
    protected int widthToDraw,heightToDraw;
    public static boolean fireBallDir;
    private float width,height;
    Herolvl1 herolvl1;
    EnemyManager enemyManager;
    public FireballLeft(EnemyManager enemyManager){
        this.enemyManager=enemyManager;
    }
    public FireballLeft(int x, int y,boolean isFacingRight) {
//        super(x+10,y,212,240,62);
        super((float) (x+(5.555*SCALE)),y,(int) (66.67*SCALE),(int) (66.67*SCALE),62,59);

//        this.herolvl1=herolvl1;
        initialX=x;
        fireaniRindex=0;
        initialY= (int) (y+(11.11*SCALE));
        width=212;
        height=240;
        widthToDraw=heightToDraw= (int) (66.67*SCALE);
//        fireballspeed = (float) (8*SCALE);
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
        hitBoxFireBallL.x -= (int) fireballspeed;
        if(hit && hasPlayedOnce){
            remove=true;
        }
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
    public void fireBallRenderL(Graphics g) {
        updateFireballPos();
//        if((hitBoxFireBall.x<=GAME_WIDTH) || (hitBoxFireBall.x<=(hitBoxBoss.x))) {
        g.drawImage(fireballSpritesR[fireaniRindex], hitBoxFireBallL.x, hitBoxFireBallL.y, widthToDraw, heightToDraw, null);
//       if((hitBoxFireBallL.x>=hitBoxBoss.x+(hitBoxBoss.width/2)) || (hitBoxFireBallL.x<=hitBoxBoss.x)){
//        if(!hit){
//        drawFireBallLHitBox(g);
//         }
//       }
        if(((hitBoxFireBallL.x<=(hitBoxBoss.x+(hitBoxBoss.width/2)))&&(hitBoxFireBallL.x>=(hitBoxBoss.x)))&&((int) (hitBoxFireBallL.y+(20.777*SCALE))>=hitBoxBoss.y) && !EnemyManager.isBossHasDiedNow()) {
            Arrays.fill(fireballSpritesR, null);
            EnemyManager.setFlinching(true);
            if(count==0){
                setHit();
                EnemyManager.changeBossHealth(-5);
                count++;
            }
        }
    }
//    public void setFiring(boolean b) {
//        this.firing=b;
//    }

//    public void setFiring(boolean b){
//        this.firing = b;
//        if(this.firing){
//            fireBallRender(g1);
//        }
//    }


//    public static boolean getFiring(){
//        return firing;
//    }

//    public void resetFireBallPos(int x, int y) {
//        this.x=x;
//        this.y=y;
//    }
}

