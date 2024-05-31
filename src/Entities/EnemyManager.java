package Entities;

import gamestates.Playing;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import static main.Game.GAME_WIDTH;
import static main.Game.SCALE;
import static utilz.Constants.EnemyConstants.*;

public class EnemyManager extends Entity{
    private Rectangle attackBox2;
    private Rectangle attackBox1;
    private int deathCount=0,afterDeadCount=0,attackAniResetCount=0,gameOverCount=0;
    public Fireball fireball;
//    private FireballLeft fireballL=new FireballLeft(this);
    private int aniIndex,aniTick,aniSpeed=19,enemyState,requiredBossIndex=BOSS_IDLE,count,checkl,flinchOnlyOnce;
    public boolean hasPlayedOnce=false;
    public static boolean bossLookRight;
    public boolean attack1;
    public static boolean attack1R;
    public boolean attack2;
    public boolean attack,attacking,walking=false;
    public static boolean isBossDead=false;
    public static boolean bossHasDiedNow=false;
    public static boolean flinching=false;
    public boolean isWalkingL,isWalkingR;
    //BossHealthBar img stats
    private int bossHealthBarWidthImg= (int) (275*SCALE);
    private int bossHealthBarHeightImg= (int) (88*SCALE);
    private int bossHealthBarXImg= (int) (546.33*SCALE);
    private float bossHealthBarYImg= (float) (8.11*SCALE);
    //BossHealthBar
    private int bossHealthBarStartX= (int) (572.22*SCALE);
    private int bossHealthBarStartY= (int) (20.22*SCALE);
    private int bossHealthBarWidth= (int) (169*SCALE);
    private int bossHealthBarHeight= (int) (22.22*SCALE);
    private static int bossMaxHealth=100;
    private static int bossCurrentHealth=bossMaxHealth;
    private int varyingBossHealthwidth= (int) bossHealthBarWidth;
    private float xSpeed;
//    Enemy enemy=new Enemy(x,y,(int)(BOSS_WIDTH*1.4),(int)(BOSS_HEIGHT*1.4));
    Playing playing;
    Herolvl1 herolvl1;
    public float x= (float) (277.77*SCALE);
    public float y= (float) (117.77*SCALE);
    public BufferedImage bossWalk,bossWalkL,bossAttackL,bossAttack,bossAttack2,bossAttack2L,bossFLinchL,bossFlinch,bossIsDead,bossIdle,bossIdleL,bossHealthBar;
    public BufferedImage[] bossAnimations=new BufferedImage[20];
    public EnemyManager(Playing playing,Herolvl1 herolvl1){
        super((float) (600.66*SCALE),(float)183.33*SCALE,(int)((BOSS_WIDTH*1.4)/5),(int)((BOSS_HEIGHT*1.4)/3), 6.99F);
        this.playing=playing;
        this.herolvl1=herolvl1;
//        fireball=new Fireball(this);
        loadBossSprites();
        initattackBox2();
        initattackBox1();
//        initBossHitBox();
    }

    private void initattackBox1() {
        attackBox1=new Rectangle((int) (x+(43.33*SCALE)), (int) (y+(66.66*SCALE)), (int) (hitBoxBoss.width-(11.11*SCALE)),hitBoxBoss.height);
    }

    private void initattackBox2() {
        attackBox2=new Rectangle((int) (x+(190.555*SCALE)), (int) (y+(85.33*SCALE)), (int) (340*SCALE), (int) (30*SCALE));
    }

    public void newState(int requiredIndex){
        this.requiredBossIndex=requiredIndex;
        aniIndex=0;
        aniTick=0;
    }
//    public void update(){
//       enemy.update();
//    }
//    public void changeBossTemp(){
//        this.x+=1;
////        hitBoxBoss.x+=1;
//
//    }

public void update(){
//    System.out.println(hitBoxBoss.x);
        updateBossHealthBar();
    bossAnimation();
   updateBossAction();
    updateAttackBox1();
    }
//

    public static boolean isBossLookRight() {
        return bossLookRight;
    }

    private void updateAttackBox1() {
        if(bossLookRight){
            attackBox1.x=hitBoxBoss.x+hitBoxBoss.width;
        }
    else if(!bossLookRight){
            attackBox1.x=hitBoxBoss.x-attackBox1.width;
        }

    }

//    private void updateAttackBox2() {
//        if(isWalkingL){
//            attackBox2.x-=1;
//        }
//        else if(isWalkingR){
//            attackBox2.x+=1;
//        }
//    }

    private void updateBossHealthBar() {
        int varyingTempHealth = varyingBossHealthwidth;
        varyingBossHealthwidth=(int)((bossCurrentHealth/(float)bossMaxHealth)*bossHealthBarWidth);
//        if(varyingBossHealthwidth!=varyingTempHealth){
//            bossHealthBarStartX=bossHealthBarStartX+(bossHealthBarWidth-varyingBossHealthwidth);
//            varyingTempHealth=varyingBossHealthwidth;
//        }
    }

    public void goTowardsHero(){
//        System.out.println(isWalkingL);
        if(playing.getHero1().getHitBoxX()<hitBoxBoss.x){
            bossWalk();
            hitBoxBoss.x-=1;
            attackBox2.x-=1;
            attackBox1.x-=1;
        }
        else if(playing.getHero1().getHitBoxX()>hitBoxBoss.x){
            bossWalkL();
            hitBoxBoss.x+=1;
            attackBox2.x+=1;
            attackBox1.x+=1;
        }
    }
    public boolean heroInRange(){
        return true;
    }
    private boolean attackRange() {
        int attackDist=Math.abs(playing.getHero1().getHitBoxX()- (int)hitBoxBoss.x);
        return attackDist<=88.333*SCALE;
    }
//    private boolean attackRange2() {
//        int attackDist=Math.abs(playing.getHero1().getHitBoxX()- (int)hitBoxBoss.x);
//        return attackDist<=88.333*SCALE;
//    }
    public boolean checkDir(){
        return  (playing.getHero1().getHitBoxX()>=hitBoxBoss.x);
    }

    private void updateBossAction() {
      if(Herolvl1.getIsHeroALive()){
        if(flinching || (flinching&&attacking)){
//            walking=false;
           if(checkDir()){
//               hitBoxBoss.x +=500;
//               newState(BOSS_FLINCH);
               if(!isBossDead){
                   bossFlinchL();
                   hitBoxBoss.x -=1;
                   attackBox2.x-=1;
                   attackBox1.x-=1;
               }
               else {
//                   newState(BOSS_DEAD);
                   if(deathCount==0) {
                       aniTick = 0;
                       aniIndex = 0;
                       bossIsDead();
                       deathCount++;
                   }
               }
           }
           else {
//               newState(BOSS_FLINCH);
               if(!isBossDead){
               bossFlinch();
                   hitBoxBoss.x +=1;
                   attackBox2.x+=1;
                   attackBox1.x+=1;
               }
              else {
//                  newState(BOSS_DEAD);
                   if(deathCount==0) {
                       aniTick = 0;
                       aniIndex = 0;
                       bossIsDead();
                       deathCount++;
                   }
               }
           }
    }
        else if(isBossDead){
            setFlinching(false);
//            newState(BOSS_DEAD);
            if(deathCount==0) {
                aniTick = 0;
                aniIndex = 0;
                bossIsDead();
                deathCount++;
            }
        }
        else {
            if (attackRange() && !flinching) {
                if(attackAniResetCount==0){
                    aniTick=0;
                    aniIndex=0;
                    attackAniResetCount++;
                }
                walking = false;
//                 if(flinching || (flinching&&attacking)){
//                     flinching=true;
//                 }
                    if (checkDir()) {
                        if (count == 2) {
                            bossA2L();
                            attacking = true;
//                            count=0;
                        } else {
                            bossA1L();
                            attacking = true;
//                            count++;
                        }
                    } else {
                        if (count == 2) {
                            bossA2();
                            attacking = true;
//                            count=0;
                        } else {
                            bossA1();
                            attacking = true;
//                            count++;
                        }
                    }

//                else{
//                    if(checkDir()){
//                        bossA2L();
//                        attacking = true;
////                        count=0;
//                    }
//                    else {
//                        bossA2();
//                        attacking = true;
////                        count=0;
//                    }
//                }
            }

            else if(!attackRange() && !attacking){
                attacking=false;
                walking=true;
            goTowardsHero();
            count=0;
            if(attackRange()){
                aniIndex=0;
                aniTick=0;
            }
            }
            else if(requiredBossIndex==BOSS_IDLE){
                 attacking=false;
                 walking=true;
                 goTowardsHero();
                 count=0;
                 if(attackRange()){
                     aniIndex=0;
                     aniTick=0;
                 }
             }
        }
    }
      else if (!Herolvl1.getIsHeroALive() && hasPlayedOnce) {
          if(afterDeadCount==0){
          if(checkDir()){
//              bossIdle();
             bossWalkL();
          }
          else {
//              bossIdleL();
              bossWalk();
          }
          afterDeadCount++;
      }
          if(bossLookRight){
              hitBoxBoss.x+=1;
              attackBox2.x+=1;
              if(hitBoxBoss.x>=GAME_WIDTH+hitBoxBoss.width){
                  if(gameOverCount==0){
                  hitBoxBoss.x+=0;
                  Playing.setGameOver(true);
                  gameOverCount++;
              }}
          } else if (!bossLookRight) {
              hitBoxBoss.x-=1;
              attackBox1.x-=1;
              if(hitBoxBoss.x<=(0-hitBoxBoss.width)){
                  if(gameOverCount==0){
                  hitBoxBoss.x+=0;
                  Playing.setGameOver(true);
                  gameOverCount++;
              }}
          }
//          boss
      }
    }

    public static void changeBossHealth(int Damage) {
            bossCurrentHealth += Damage;
        if(bossCurrentHealth>=bossMaxHealth){
            bossCurrentHealth=bossMaxHealth;
        }
        else if (bossCurrentHealth<=0) {
            bossCurrentHealth=0;
            isBossDead=true;
        }
    }

//    private void setBossDead() {
//        isBossDead=true;
//    }

//    private void setAttack(boolean b) {
////        System.out.println("IM in attack");
//        attack=true;
//        if(!attack){
//            System.out.println(attack);
//        }
//    }

    public static boolean isBossHasDiedNow() {
        return bossHasDiedNow;
    }

    public void renderBoss(Graphics g){
        drawBossHealth(g);
//        drawAttackbox2(g);
//        drawBossHitBox(g);
//        drawAttackbox1(g);
        if(!bossHasDiedNow){
            g.drawImage(bossAnimations[aniIndex],(int)((hitBoxBoss.x-(138.33*SCALE))),(int)(hitBoxBoss.y-(65.5555*SCALE)),(int)(BOSS_WIDTH*1.4),(int)(BOSS_HEIGHT*1.4),null);
        }
        else {
            Arrays.fill(bossAnimations, null);
        }
    }

    private void drawAttackbox1(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(attackBox1.x,attackBox1.y,attackBox1.width,attackBox1.height);
    }

    private void drawAttackbox2(Graphics g) {
        g.setColor(Color.YELLOW);
        g.drawRect(attackBox2.x,attackBox2.y,attackBox2.width,attackBox2.height);
    }

    private void drawBossHealth(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(bossHealthBarStartX,bossHealthBarStartY,varyingBossHealthwidth,bossHealthBarHeight);
        g.drawImage(bossHealthBar,(int)bossHealthBarXImg,(int)bossHealthBarYImg,bossHealthBarWidthImg,bossHealthBarHeightImg,null);
    }

    private void bossAnimation(){
//        boolean damageDone=false;
//        System.out.println(count);
//        System.out.println(attacking);
//        if(isBossDead){
//            bossIsDead();
//        }
//        System.out.println(bossCurrentHealth);
//        hasPlayedOnce=false;
//        if(isBossDead){
//            System.out.println("HIIIIIII");
//        }
        aniTick++;
        if(aniTick>=aniSpeed){
            aniTick=0;
            aniIndex++;
            if(attack1){
                if(aniIndex==9){
                    if(herolvl1.hitBox.intersects(attackBox1)){
                        herolvl1.setFlinching(true,attack1);
//                        damageDone=true;
                    }
//                    if(count==0){
//                    count++;
//                    }
                }
            }
//            if(attack2){
//                if(aniIndex==7 || aniIndex==8 || aniIndex==9 || aniIndex==10 || aniIndex==11 || aniIndex==12){
//                    if(herolvl1.hitBox.intersects(attackBox1)){
//                        herolvl1.setFlinching(true,attack1);
//                    }
//                }
//            }
            if (aniIndex>=requiredBossIndex){
//                        if(isBossDead){
//            Arrays.fill(bossAnimations, null);
//        }
//                if(isBossDead){
//                }
//                 isBossDead=false;
//                 bossCurrentHealth=-100;
//                }
                if(requiredBossIndex==BOSS_FLINCH){
//                    changeBossHealth(-2);
                    setFlinching(false);
                    requiredBossIndex=BOSS_IDLE;
//                    count=0;
                    if(checkDir()){
                        {
                            bossIdleL();
                        }
                    }
                    else {
                        bossIdle();
                    }
                }
                else if(requiredBossIndex==BOSS_DEAD) {
                      setBossHasDiedNow();
                } else if (requiredBossIndex==BOSS_A1) {
                    attackAniResetCount=0;
//                    hasPlayedOnce = true;
//                    count++;
//                    aniTick = 0;
//                    aniIndex = 0;
//                    if(count!=0 && !damageDone){
//                        count++;
//                    }
                    attacking = false;
                    attack1 = false;
                    if(Herolvl1.isAlive)
                    {   if (checkDir()) {
                        bossIdle();
                    } else {
                        bossIdleL();
                    }
                }
                    else if(!Herolvl1.isAlive){
                        hasPlayedOnce=true;
                    }
//                    if(herolvl1.hitBox.intersects(attackBox1)){
//                          herolvl1.setFlinching(true);
//                    }
                }
                else if(requiredBossIndex==BOSS_A2) {
                    attackAniResetCount=0;
                    hasPlayedOnce=true;
                    attack2 = false;
                    attacking = false;
                    count = 0;
                    if(Herolvl1.isAlive) {   if (checkDir()) {
                        bossIdle();
                    } else {
                        bossIdleL();
                    }
                }
                    else if(!Herolvl1.isAlive){
                        hasPlayedOnce=true;
                    }
                }
//                if(requiredBossIndex==BOSS_A1){
//                    count++;
//                    setAttack(false);
//                    requiredBossIndex=BOSS_IDLE;
//                    if(checkDir()){ bossIdleL();
//                    }
//                    else {
//                        bossIdleL();
//                    }
//                }  if(requiredBossIndex==BOSS_A2){
//                    count=0;
//                    setAttack(false);
//                }
//                if (requiredBossIndex==BOSS_A2||requiredBossIndex==BOSS_A1){
//                    setAttack(false);
////                    requiredBossIndex=BOSS_IDLE;
////                    if(checkDir()) {
////                    bossIdle();}
////                    else {
////                        bossIdleL();
////                    }
//                }
                   aniIndex=0;
                }
//            hasPlayedOnce=false;
            }
        }

    private void setBossHasDiedNow() {
        bossHasDiedNow=true;
        Playing.setDemoWinScreen(true);
    }

    public static void setFlinching(boolean b) {
        flinching=b;
//        if(!flinching) {
        }

    public void bossWalk(){
        attack1=false;
        attack2=false;
        attack1R=false;
        bossLookRight=false;
        requiredBossIndex=BOSS_WALK;
        for(int i=0;i<BOSS_WALK;i++){
            bossAnimations[i]=bossWalk.getSubimage(i*256,0,256,256);
        }
    }
    public void bossWalkL(){
        attack1=false;
        attack2=false;
        attack1R=false;
        bossLookRight=true;
        requiredBossIndex=BOSS_WALK;
        for(int i=0;i<BOSS_WALK;i++){
            bossAnimations[i]=bossWalkL.getSubimage(i*256,0,256,256);
        }
    }
    public void bossA1L(){
        attack1=true;
        attack1R=false;
        attack2=false;
        bossLookRight=true;
        requiredBossIndex=BOSS_A1;
        for(int i=0;i<BOSS_A1;i++){
            bossAnimations[i]=bossAttackL.getSubimage(i*256,0,256,256);
        }
    }
    public void bossA2L(){
//        count=0;
        attack1=false;
        attack2=true;
        attack1R=false;
        bossLookRight=true;
        requiredBossIndex=BOSS_A2;
        for(int i=0;i<BOSS_A2;i++){
            bossAnimations[i]=bossAttack2L.getSubimage(i*256,0,256,256);
        }
    }
    public void bossA1(){
        attack1=true;
        attack1R=true;
        attack2=false;
        bossLookRight=false;
        requiredBossIndex=BOSS_A1;
        for(int i=0;i<BOSS_A1;i++){
            bossAnimations[i]=bossAttack.getSubimage(i*256,0,256,256);
        }
    }
    public void bossIdleL(){
//        count=0;
        attack1R=false;
        attack1=false;
        attack2=false;
        bossLookRight=true;
        requiredBossIndex=BOSS_IDLE;
        for(int i=0;i<BOSS_IDLE;i++){
            bossAnimations[i]=bossIdleL.getSubimage(i*256,0,256,256);
        }
    }
    public void bossFlinchL(){
        attack1R=false;
        attack1=false;
        attack2=false;
        bossLookRight=true;
//        checklr=94;
        requiredBossIndex=BOSS_FLINCH;
        for(int i=0;i<BOSS_FLINCH;i++){
            bossAnimations[i]=bossFLinchL.getSubimage(i*256,0,256,256);
        }
    }
    public void bossA2(){
//        count=0;
        attack1R=false;
        attack1=false;
        attack2=true;
        bossLookRight=false;
        requiredBossIndex=BOSS_A2;
        for(int i=0;i<BOSS_A2;i++){
            bossAnimations[i]=bossAttack2.getSubimage(i*256,0,256,256);
        }
    }
    public void bossFlinch(){
        attack1R=false;
        attack1=false;
        attack2=false;
        bossLookRight=false;
        requiredBossIndex=BOSS_FLINCH;
        for(int i=0;i<BOSS_FLINCH;i++){
            bossAnimations[i]=bossFlinch.getSubimage(i*256,0,256,256);
        }
    }
    public void bossIsDead(){
        attack1R=false;
        attack1=false;
        attack2=false;
        bossLookRight=false;
        requiredBossIndex=BOSS_DEAD;
        for(int i=0;i<BOSS_DEAD;i++){
            bossAnimations[i]=bossIsDead.getSubimage(i*256,0,256,256);
        }
    }
    public void bossIdle(){
        attack1R=false;
        attack1=false;
        attack2=false;
        bossLookRight=false;
        requiredBossIndex=BOSS_IDLE;
        for(int i=0;i<BOSS_IDLE;i++){
            bossAnimations[i]=bossIdle.getSubimage(i*256,0,256,256);
        }
    }

    public static boolean isAttack1R() {
        return attack1R;
    }

    private void loadBossSprites() {
        bossAttack= LoadSave.GetBossA1();
        bossAttack2=LoadSave.GetBossA2();
        bossFlinch=LoadSave.GetBossFlinch();
        bossIdle=LoadSave.GetBossIdle();
        bossWalk=LoadSave.GetBossWalk();
        bossIsDead=LoadSave.GetBossDies();
        bossHealthBar=LoadSave.GetBossHealthBar();
        bossWalkL=LoadSave.GetBossWalkL();
        bossFLinchL=LoadSave.GetBossFlinchL();
        bossIdleL=LoadSave.GetBossIdleL();
        bossAttackL=LoadSave.GetBossA1L();
        bossAttack2L=LoadSave.GetBossA2L();
        for(int i=0;i<BOSS_IDLE;i++){
            bossAnimations[i]=bossIdle.getSubimage(i*256,0,256,256);
        }
    }

    public void resetAll() {
        bossHasDiedNow=false;
        deathCount=0;
        afterDeadCount=0;
        attackAniResetCount=0;
        gameOverCount=0;
        flinching=false;
        attack=false;
        attack2=false;
        attacking=false;
        isBossDead=false;
        hasPlayedOnce=false;
        bossCurrentHealth=bossMaxHealth;
        bossIdle();
        hitBoxBoss.x= (int) (600.55*SCALE);
        attackBox2.x= (int) (x+190.55*SCALE);
    }
}
