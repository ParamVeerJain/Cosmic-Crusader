package Entities;

//import utilz.LoadSave;

import utilz.HelpMethods;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static main.Game.GAME_WIDTH;
import static main.Game.SCALE;
import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.PlayerConstants.KICK;


public class Herolvl1 extends Entity {
    private boolean left, right,jump,facingRight=true,firing=false,flinching=false;
    private int anitick, aniRindex, aniCindex, herofpsspeed = 8, requiredindex = IDLE, checklr;
    public static boolean isCrouching=false;
    public static boolean isAlive=true;
   private int crouchCount=0;
    private BufferedImage h1idleani,h1walk, h1run,h1ko,h1ko2,h1flinch,h1flinchL, h1airidle,h1fcLeft,h1fblLeft, h1jump1, h1jump2,h1jump2l,h1land,h1PowerUp,h1PowerUpL, h1crouch, h1kick,h1kickl, h1idleaniL,h1runL,h1walkL,h1crouchL,h1fbc,h1fbl;
    private BufferedImage[] animations = new BufferedImage[26];
    private BufferedImage[] animations1 = new BufferedImage[26];
    public boolean poweringUp=false;
    //HealthBarImgStats
    private BufferedImage heroHealthBarImg;
    private float healthBarWidthImg=128*SCALE;
    private float healthBarHeightImg=58*SCALE;
    private float healthBarXImg= (float) (1.111*SCALE);
    private float healthBarYImg=(float)(0.11*SCALE);
    //HealthBar
    private int healthBarStartX= (int) (60.55*SCALE);
    private int healthBarStartY= (int) (20.44*SCALE);
    private int healthBarWidth= (int) (113.4*SCALE);
    private int healthBarHeight= (int) (18.666*SCALE);
    private static int maxHealth=100;
    private static int currentHealth=maxHealth;
    private int varyingHealthwidth= (int) healthBarWidth;
    //  Jumping/Gravity
    private float airSpeed=0f;
    private float gravity=0.04f*SCALE;
    private  float jumpSpeed=-3f*SCALE;
    private float fallSpeedAfterCollision=0.5f;
    public boolean inAir=false;
    private int[][] tileData;
    private ArrayList<BufferedImage> firesprites;
    //fireball
    private int fire=1;
    public boolean isFireBallActive;
    public int fireBallTick;
    private int fireGrowSpeed=15;
    private int fireGrowTick;
    //FireBallBar
    private BufferedImage fireBarImg;
    private int fireBarWidthImg= (int) (122*SCALE);
    private int fireBarHeightImg= (int) (30.5*SCALE);
    private int fireBarXImg= (int) (70.111*SCALE);
    private int fireBarYImg= (int) (45.11*SCALE);
    private int fireBarStartX= (int) (87.33*SCALE);
    private int fireBarStartY= (int) (60.555*SCALE);
    private int fireBarWidth= (int) (90.888*SCALE);
    private int fireBarHeight= (int) (8*SCALE);
    private int fireCurrentWidth=fireBarWidth;
    private int fireMax=100;
    private int fireValue=fireMax;

    private static boolean fireTheBall,fireTheLeftBall;
    private ArrayList<Fireball> fireballs;
    private ArrayList<FireballLeft> fireballsLeft;
    private int initialX,initialY;

    public static boolean isIsCrouching() {
        return isCrouching;
    }

    public static void setIsCrouching(boolean isCrouching) {
        Herolvl1.isCrouching = isCrouching;
    }

    public Herolvl1(float x, float y, int width, int height) {
        super(x, y,width,height);
        initialX= (int) x;
        initialY= (int) y;
        initHitBox();
        h1animatestore();
//        fireball1=new Fireball(this);
        fireballs=new ArrayList<Fireball>();
        fireballsLeft=new ArrayList<FireballLeft>();
    }
    public void changeHeroHealth(int damage){
        currentHealth+=damage;
        if(currentHealth>=maxHealth){
            currentHealth=maxHealth;
        }
        else if(currentHealth<=0){
            currentHealth=0;
            setIsAlive();
//            flinching=false;
//            facingRight=false;
//            right=false;
//            left=false;
//            aniRindex=0;
//            anitick=0;
//            KO(-100);
//            System.out.println("Im in");
        }
    }

    private static void setIsAlive() {
        isAlive=false;

//        setKO();
    }
    public static boolean getIsHeroALive(){
        return isAlive;
    }
    public void setFlinching(boolean flinching,boolean attack1) {
        if(isAlive){
        this.flinching = flinching;
        if(attack1) {
            changeHeroHealth(-25);
            if (EnemyManager.isAttack1R() && isFacingRight()) {
                anitick = 0;
                aniRindex = 0;
                if(isAlive){
                flinchHero(9865);
                changedx(-35);
                } else if (!isAlive) {
                    anitick = 0;
                    aniRindex = 0;
                    KO2(-100);
                }
            } else if (EnemyManager.isAttack1R() && !isFacingRight()) {
                anitick = 0;
                aniRindex = 0;
                if(isAlive){
                flinchHeroL(-9865);
                changedx(-35);
            } else if (!isAlive) {
                    anitick = 0;
                    aniRindex = 0;
                    KO2(-100);
                }
            } else if (!EnemyManager.isAttack1R() && !isFacingRight()) {
                anitick = 0;
                aniRindex = 0;
                if(isAlive){
                flinchHeroL(-9865);
                changedx(45);
            } else if (!isAlive) {
                    anitick = 0;
                    aniRindex = 0;
                    KO2(-100);
                }
            }
            else if (!EnemyManager.isAttack1R() && isFacingRight()) {
                anitick = 0;
                aniRindex = 0;
                if(isAlive){
                flinchHero(9865);
                changedx(45);
            } else if (!isAlive) {
                    anitick = 0;
                    aniRindex = 0;
                    KO2(-100);
                }
            }
        }
    }
    }

    private void updateFireBar(){
        fireCurrentWidth=(int)(((fireValue/(float)fireMax))*fireBarWidth);
       if(firing){
        fireGrowTick++;
        if(fireGrowTick>=fireGrowSpeed){
            fireGrowTick=0;
            changeFirePower(1);
        }
       }
    }

    public void changeFirePower(int i) {
        fireValue+=i;
        if(fireValue>=fireMax){
            fireValue=fireMax;
        } else if (fireValue<=0) {
            fireValue=0;
        }
    }

    public boolean getFireValue() {
        return (fireValue>=20);
    }

    public void setPoweringUp(boolean p) {
        poweringUp=p;
    }

    public int getFire(){
        return fire;
    }
    public static void setFireTheBall(boolean bool){
        fireTheBall=bool;
    }
    public static void setFireTheLeftBall(boolean bool){
        fireTheLeftBall=bool;
    }


    public void h1animatestore() {
        h1idleani= LoadSave.GetIdle();
        h1idleaniL=LoadSave.GetIdleL();
        h1run=LoadSave.GetRun();
        h1runL=LoadSave.GetRunL();
        h1walk=LoadSave.GetWalk();
        h1walkL=LoadSave.GetWalkL();
        h1crouch=LoadSave.GetCrouch();
        h1crouchL=LoadSave.GetCrouchL();
        h1kick=LoadSave.GetKick();
        h1kickl=LoadSave.GetKickL();
        h1fbc=LoadSave.GetFireCharge();
        h1fcLeft=LoadSave.GetFireChargeL();
        h1fbl=LoadSave.GetFireLaunch();
        h1fblLeft=LoadSave.GetFireLaunchL();
        h1jump2=LoadSave.GetJ1();
        h1jump2l=LoadSave.GetJ2L();
        h1airidle=LoadSave.GetAA();
        h1land=LoadSave.GetLanding();
        h1PowerUp=LoadSave.GetPowerUp();
        h1PowerUpL=LoadSave.GetPowerUpL();
        h1flinch=LoadSave.GetHeroflinch();
        h1flinchL=LoadSave.GetHeroflinchL();
        h1ko=LoadSave.GetHeroKO();
        h1ko2=LoadSave.GetHeroKO2();
        heroHealthBarImg=LoadSave.GetHealthBar();
        fireBarImg=LoadSave.GetFireBallBar();
        for (int i = 0; i < animations1.length; i++) {
            animations1[i] = h1idleani.getSubimage(i * 256, 0, 256, 256);
            animations[i] = h1idleani.getSubimage(i * 256, 0, 256, 256);
        }
    }
    public void loadTileData(int[][] tileData){
        this.tileData=tileData;
//        this.lvlData=lvlData;
    }
    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean isFacingRight() {
        return facingRight;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public boolean isRight() {
        return right;
    }


    public void setRight(boolean right, boolean left) {
        this.right = right;
        this.left = left;
    }



    public void update() {
//        System.out.println("Health ="+currentHealth);
   //  System.out.println("Xindex="+(int)((x+(100*SCALE))/TILES_SIZE) +"   Yindex="+(int)((y+(43.33*SCALE))/TILES_SIZE)+"  Tile Value="+tileData[(int)((y+(43.33*SCALE))/TILES_SIZE)][(int)((x+(100*SCALE))/TILES_SIZE) ]);
        //here Xindex is column meaning height and Yindex is rows meaning width
//        System.out.println("hX= "+hitBox.x +"  hY="+hitBox.y);
//        System.out.println(hitBox.width);
//        System.out.println(TILES_SIZE)
//     System.out.println("X= "+(int)((x+(100*SCALE))) +"  Y="+(int)((y+(43.33*SCALE))));
//        System.out.println("Y="+y);
//        System.out.println("X="+x);
//        System.out.println(inAir);
//        System.out.println("Jump"+jump+"  inAir"+inAir);
        if(fireTheBall ) {
//            System.out.println("IM SHOOTING THE FIREBALL!");
            Fireball fireball = new Fireball(hitBox.x, hitBox.y, isRight());
            fireballs.add(fireball);
            fireTheBall=false;
        }
        if(fireTheLeftBall){
            FireballLeft fireBallLeft=new FireballLeft(hitBox.x,hitBox.y,isRight());
            fireballsLeft.add(fireBallLeft);
            fireTheLeftBall=false;
        }
        updateHealthBar();
        updateFireBar();
        getHitBoxX();
        getHitBoxY();
        updatePos();
        updateHitBox();
        animations();
    }

    private void updateHealthBar() {
        varyingHealthwidth=(int)((currentHealth/(float)maxHealth)*healthBarWidth);
    }

    public int getHitBoxY() {
        return hitBox.y;
    }

    public int getHitBoxX() {
         return hitBox.x;
    }
    public void setHitBox(boolean crouch){
        if(crouch){
            if(crouchCount==0) {
                hitBox.height = hitBox.height / 2;
                crouchCount++;
            }
        }
        else {
            hitBox.height = hitBox.height * 2;
            crouchCount=0;
        }
    }

    public void setLeftOnly(boolean left){
        this.left=left;
    } public void setRightOnly(boolean right){
        this.right=right;
    }

    private void updatePos() {
        if(jump){
            jump();
        }
        if (left && (!right && !inAir)) {
            if (HelpMethods.CanMoveHere(hitBox.x, hitBox.y, (int) hitBox.width, (int) hitBox.height, tileData) == 100) {
                if (checklr == -2) {
                    runL(-2);
                } else if (checklr == 1) {
                    walkL(1);
                }
            } else {

                if (checklr == -2) {
                    runL(77);
                } else if (checklr == 1) {
                    walkL(11);
                }
            }
        }

        else if (right && (!left && !inAir)) {
            if (HelpMethods.CanMoveHere(hitBox.x, hitBox.y, (int) hitBox.width, (int) hitBox.height, tileData) == 100) {

                if (checklr == 2) {
                    run(2);
                } else if (checklr == -1) {
                    walk(-1);
                }
            }
            else {
                if (checklr == 2) {
                    run(78);
                }
                else if (checklr == -1) {
                    walk(12);
                }
            }
        }

        else if ((right && left && !inAir)) {
            defaultani();
        }
//        if(!inAir){
//            if((HelpMethods.IsEntityOnFLoor(y,hitBox.x,hitBox.y,hitBox.width,hitBox.height,tileData))&& y<=245){
//                inAir=true;
//            }
//        }
        if(right && !left && inAir){
            if(HelpMethods.CanJumpHere(hitBox.x,hitBox.y,hitBox.width, hitBox.height, tileData))
            {
//                System.out.println("Im in");
                updateXPos();
                this.y +=airSpeed;
                if((HelpMethods.CanMoveHere(hitBox.x,hitBox.y,hitBox.width,hitBox.height,tileData))==100){
                    this.x+=4f;
                }
                airSpeed +=gravity;
                if(facingRight){
                    jumpani(94);
                }
                else {
                    jumpaniL(95);
                }

            }
            else {
//                System.out.println("im in else");
                this.y = HelpMethods.GetEntityYPosForFLoor(hitBox.x, hitBox.y, hitBox.width, hitBox.height, tileData, airSpeed);
                if (airSpeed > 0) {
                    resetInAir();
                    run(2);
                    aniRindex=0;
                }
//                   updateXPos();
            }

        }
        if(left && !right && inAir){
            if(HelpMethods.CanJumpHere(hitBox.x,hitBox.y,hitBox.width,hitBox.height,tileData)){
                 updateXPos();
                 this.y+=airSpeed;
                 if((HelpMethods.CanMoveHere(hitBox.x,hitBox.y,hitBox.width,hitBox.height,tileData))==100){
                     this.x-=4f;
                 }
                 airSpeed+=gravity;
                 if(facingRight){
                     jumpani(94);
                 }
                 else {
                     jumpaniL(95);
                 }

            }
            else {
                this.y=HelpMethods.GetEntityYPosForFLoor(hitBox.x,hitBox.y,hitBox.width,hitBox.height,tileData,airSpeed);
                if(airSpeed>0){
                    resetInAir();
                    runL(-2);
                    aniRindex=0;
                }
            }

        }
        if(!right && !left && inAir){
            if(HelpMethods.CanJumpHere(hitBox.x,hitBox.y,hitBox.width,hitBox.height,tileData)){
                updateXPos();
                this.y+=airSpeed;
                airSpeed+=gravity;
                if(facingRight){
                    jumpani(94);
                }
                else {
                    jumpaniL(95);
                }
            }
            else {
                this.y=HelpMethods.GetEntityYPosForFLoor(hitBox.x,hitBox.y,hitBox.width,hitBox.height,tileData,airSpeed);
                if(airSpeed>0){
                    resetInAir();
                }

            }
        }
    }
    public boolean getInAir(){
        return inAir;
    }
    public boolean getFacingRight(){
        return facingRight;
    }

    private void jump() {
        if(inAir){
            return;
        }
        inAir=true;
        airSpeed=jumpSpeed;
    }

    private void resetInAir() {
        inAir=false;
        if (left && !right) {
            if (HelpMethods.CanMoveHere(hitBox.x, hitBox.y, (int) hitBox.width, (int) hitBox.height, tileData) == 100) {
                if (checklr == -2) {
                    runL(-2);
                } else if (checklr == 1) {
                    walkL(1);
                }
            } else {

                if (checklr == -2) {
                    runL(77);
                } else if (checklr == 1) {
                    walkL(11);
                }
            }

        }

        else if (right && !left) {
            if (HelpMethods.CanMoveHere(hitBox.x, hitBox.y, (int) hitBox.width, (int) hitBox.height, tileData) == 100) {

                if (checklr == 2) {
                    run(2);
                } else if (checklr == -1) {
                    walk(-1);
                }
            }
            else {
                if (checklr == 2) {
                    run(78);
                }
                else if (checklr == -1) {
                    walk(12);
                }
            }
        }
        else {
            if(facingRight){
            defaultani();}
            else {
                defaultaniL();
            }
        }
        airSpeed=0;
    }

    private void updateXPos() {
      if(HelpMethods.CanJumpHere(hitBox.x,hitBox.y, hitBox.width, hitBox.height, tileData)){
        if (left && !right) {
            if (HelpMethods.CanMoveHere(hitBox.x, hitBox.y, (int) hitBox.width, (int) hitBox.height, tileData)==4) {
                changedx((int)(-3*SCALE));
            }
            }
        else if (right && !left) {
            if (HelpMethods.CanMoveHere(hitBox.x, hitBox.y, (int) hitBox.width, (int) hitBox.height, tileData)==5) {
                changedx((int)(3*SCALE));
            }
            }
        else {
            hitBox.x=HelpMethods.GetEntityPosNextToWall(hitBox.x, hitBox.y,hitBox.width,hitBox.height,tileData);
        } }
    }
    public void render(Graphics g) {
        drawHealthBarImg(g);
        drawFireBar(g);
        if(isAlive){
        g.drawImage(animations[aniRindex], (int) x, (int) y, width, height , null);
        for (int i=0;i<fireballs.size();i++)  {
                fireballs.get(i).fireBallRender(g);
        }
        for(int i=0;i<fireballsLeft.size();i++){
            fireballsLeft.get(i).fireBallRenderL(g);
        }
        }
        else {
//            deadAni();
            y= (float) (168.33*SCALE);
            deadSet();
            changedx(0);
            g.drawImage(h1ko2.getSubimage( 256, 0, 256, 256), (int) x, (int) y, width, height , null);
        }
//        else if (!isAlive) {
//            g.drawImage(animations[aniRindex], (int) x, (int) y, width, height , null);
//        }
//        drawHitBOx(g);
    }

    private void drawFireBar(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(fireBarStartX,fireBarStartY,fireCurrentWidth,fireBarHeight);
        g.drawImage(fireBarImg,fireBarXImg,fireBarYImg,fireBarWidthImg,fireBarHeightImg,null);
    }

    private void drawHealthBarImg(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(healthBarStartX,healthBarStartY,varyingHealthwidth,healthBarHeight);
        g.drawImage(heroHealthBarImg,(int)healthBarXImg,(int)healthBarYImg,(int)(healthBarWidthImg*1.5),(int)(healthBarHeightImg*1.5),null);
    }

    public void changedx(int value) //moves the character in x direction
    {
        this.x += value;
    }

    public void changedy(int value) //moves the character in y direction
    {
        this.y += value;
    }

    public void defaultani() {
        facingRight=true;
        requiredindex = IDLE;
        checklr = 0;
        //   animations[26]=animations1[26];
        for (int i = 0; i < animations1.length; i++) {
            animations[i] = h1idleani.getSubimage(i * 256, 0, 256, 256);
        }
    }
    public void defaultaniL() {
        facingRight=false;
        requiredindex = IDLE;
        checklr = 0;
        //   animations[26]=animations1[26];
        for (int i = 0; i < animations1.length; i++) {
            animations[i] = h1idleaniL.getSubimage(i * 256, 0, 256, 256);
        }
    }

    public void run(int a) {
        facingRight=true;
        checklr = a;
        requiredindex = RUN;
//        animations[26]=animations2[26];
        for (int i = 0; i < animations1.length; i++) {
            animations[i] = h1run.getSubimage(i * 256, 0, 256, 256);
        }
    }
   public void runL(int a) {
        facingRight=false;
        checklr = a;
        requiredindex = RUN;
//        animations[26]=animations2[26];
       for (int i = 0; i < animations1.length; i++) {
           animations[i] = h1runL.getSubimage(i * 256, 0, 256, 256);
       }
    }

    public void walk(int a) {
        facingRight=true;
        checklr = a;
        requiredindex = WALK;
        //   animations[26]=animations1[26];
        for (int i = 0; i < animations1.length; i++) {
            animations[i] = h1walk.getSubimage(i * 256, 0, 256, 256);
        }
    }
    public void walkL(int a) {
        facingRight=false;
        checklr = a;
        requiredindex = WALK;
        int j=0;
        //   animations[26]=animations1[26];
        for (int i = 25; i >=0; i--) {
            animations[j] = h1walkL.getSubimage(i * 256, 0, 256, 256);
            j++;
        }
    }

    public void crouch() {
        facingRight=true;
        checklr = 5;
        requiredindex = 7;
        //   animations[26]=animations1[26];
        for (int i = 0; i < requiredindex; i++) {
            animations[i] = h1crouch.getSubimage(i * 256, 0, 256, 256);
        }
    } public void crouchL(int a) {
        facingRight=false;
        checklr = a;
        requiredindex = 7;
        //   animations[26]=animations1[26];
        for (int i = 0; i < requiredindex; i++) {
            animations[i] = h1crouchL.getSubimage(i * 256, 0, 256, 256);
        }
    }

    public void kick(int a) {
        checklr = a;
        requiredindex = KICK;
        //   animations[26]=animations1[26];
        for (int i = 0; i < animations1.length; i++) {
            animations[i] = h1kick.getSubimage(i * 256, 0, 256, 256);

        }
    }
    public void kickL(int a) {
        checklr = a;
        requiredindex = KICK;
        //   animations[26]=animations1[26];
        for (int i = 0; i < animations1.length; i++) {
            animations[i] = h1kickl.getSubimage(i * 256, 0, 256, 256);
        }
    }
    public void powerHimUp() {
        facingRight=true;
        checklr = 9800;
        requiredindex = POWER_UP;
        //   animations[26]=animations1[26];
        for (int i = 0; i < animations1.length; i++) {
            animations[i] = h1PowerUp.getSubimage(i * 256, 0, 256, 256);
        }
    }
    public void powerHimUpL() {
         facingRight=false;
        checklr = 9801;
        int j=0;
        requiredindex = POWER_UP;
        //   animations[26]=animations1[26];
        for (int i = 25; i >=0; i--) {
            animations[j] = h1PowerUpL.getSubimage(i * 256, 0, 256, 256);
            j++;
        }
    }
    public void jumpani(int a) {
        facingRight=true;
        checklr = a;
        requiredindex = J2;
        //   animations[26]=animations1[26];
        for (int i = 0; i < animations1.length; i++) {
            animations[i] = h1jump2.getSubimage(i * 256, 0, 256, 256);
        }
    }
    public void jumpaniL(int a) {
        facingRight=false;
        checklr = a;
        requiredindex = J2;
        //   animations[26]=animations1[26];
        for (int i = 0; i < animations1.length; i++) {
            animations[i] = h1jump2l.getSubimage(i * 256, 0, 256, 256);
        }
    }
    public void airidle(int a) {
        checklr = a;
        requiredindex = AIRIDLE;
        //   animations[26]=animations1[26];
        for (int i = 0; i < animations1.length; i++) {
            animations[i] = h1airidle.getSubimage(i * 256, 0, 256, 256);
        }
    }
    public void land(int a) {
        checklr = a;
        requiredindex = LAND;
        //   animations[26]=animations1[26];
        for (int i = 0; i < animations1.length; i++) {
            animations[i] = h1land.getSubimage(i * 256, 0, 256, 256);
        }
    }


    public void FBC(int a) {
        checklr = a;
        requiredindex = FIREBALLCHARGE;
        int j=0;
        for (int i = 19; i < animations1.length; i++) {
            animations[j] = h1fbc.getSubimage(i * 256, 0, 256, 256);
            j++;
        }
    }
    public void FBCLeft(int a) {
        checklr = a;
        requiredindex = FIREBALLCHARGE;
        int j=0;
        for (int i = 8; i >=0; i--) {
            animations[j] = h1fcLeft.getSubimage(i * 256, 0, 256, 256);
            j++;
        }
    }
     public void FBCL(int a) {
        checklr = a;
        requiredindex = LAUNCHFB;
        //   animations[26]=animations1[26];
        for (int i = 0; i < animations1.length; i++) {
            animations[i] = h1fbl.getSubimage(i * 256, 0, 256, 256);

        }
    }
    public void KO(int a) {
//        System.out.println("KO");
        checklr = a;
        requiredindex = HERO_KO;
        //   animations[26]=animations1[26];
        for (int i = 0; i < animations1.length; i++) {
            animations1[i] = h1ko.getSubimage(i * 256, 0, 256, 256);
        }
    }
    public void KO2(int a) {
        checklr = a;
        requiredindex = HERO_KO2;
        //   animations[26]=animations1[26];
        for (int i = 0; i < HERO_KO2; i++) {
            animations1[i] = h1ko2.getSubimage(i * 256, 0, 256, 256);
        }
    }
    public void FBCLLEFT(int a) {
        checklr = a;
        requiredindex = LAUNCHFB;
        //   animations[26]=animations1[26];
        for (int i = 25; i >0; i--) {
            animations[i] = h1fblLeft.getSubimage(i * 256, 0, 256, 256);
        }
    }
    public void flinchHero(int a) {
        checklr = a;
        requiredindex = HERO_FLINCH;
//       int j=0;
        //   animations[26]=animations1[26];
        for (int i = 0; i <animations1.length; i++) {
            animations[i] = h1flinch.getSubimage(i * 256, 0, 256, 256);
        }
    }
    public void flinchHeroL(int a) {
        checklr = a;
        requiredindex = HERO_FLINCH;
        //   animations[26]=animations1[26];
        for (int i = 0; i <animations1.length; i++) {
            animations[i] = h1flinchL.getSubimage(i * 256, 0, 256, 256);
        }
    }
//    public void deadAni(){
//        anitick++;
//        if(anitick>=2){
//            anitick=0;
//            aniRindex++;
//            if(aniRindex>=requiredindex){
////                 if(requiredindex==HERO_KO && checklr==-100){
////                    System.out.println("KO2");
////                    KO2(-990);
////                }
////                else
//
//            }
//        }
//    }
    private void animations() {
//        if(isAlive){
        anitick++;
        if (anitick >= herofpsspeed) {
            anitick = 0;
            aniRindex++;
            if (aniRindex >= requiredindex) {
                if (checklr == 5) {
                    aniRindex = 6;
                }
                else if(checklr==62510){
                    aniRindex=24;
                }
                else if(checklr==8000) {
                      aniRindex = 0;
//                    setFiring(false);
                  }
                else if(checklr==8001){
                    aniRindex=0;
                }
                else if(checklr==800){
                    defaultani();
                }
                else if(checklr==801){
                    defaultaniL();
                }
                else if(checklr==999){
                    aniRindex=6;
                } else if (checklr==9800) {
                    aniRindex=7;
                }
                else if(checklr==9801){
                    aniRindex=8;
                }
                else if (checklr==62) {
                    defaultani();
                }
                else if(requiredindex==HERO_FLINCH){
                    flinching=false;
                if(checklr==9865){
                    defaultani();
                }
                else if(requiredindex==HERO_KO2 && checklr==-990){
                        aniRindex=0;
                    }
                else if(checklr==-9865){
                    defaultaniL();
                }
                }
                else if(checklr==800){
                    defaultani();
                }
//                else if(requiredindex==HERO_KO && checklr==-100){
//                    System.out.println("KO2");
//                    KO2(-990);
//                }
//                else if(requiredindex==HERO_KO2 && checklr==-990){
//                     aniRindex=0;
//                }
                else if (requiredindex==KICK) {
                    if (checklr == 9) {
                    defaultani();
                    } else if (checklr==619) {
                        defaultaniL();
                    } else if (checklr==-619) {
                        aniRindex=0;
                    } else if (checklr == -9) {
                        aniRindex=0;
                    }
                }
                else {
                    aniRindex = 0;
                }
            }
            if (checklr == -2) {   //runs left
                changedx((int)((-8.66)*(SCALE)));
            } else if (checklr == 2) {
                changedx((int)((8.66)*(SCALE)));   //runs right
            } else if (checklr == -1) {
                changedx((int)((2.88)*(SCALE)));     //walks right
            } else if (checklr == 1) {
                changedx((int)((-2.88)*(SCALE)));     //walks left
            }
            else if(checklr==77) {
                changedx(0);

                if(HelpMethods.LeftOneSideFree(hitBox.x, hitBox.y, (int) hitBox.width, (int) hitBox.height, tileData)==4)
                {
                    changedx((int)((-8.66)*(SCALE)));  //runs left

                }

            }    else if(checklr==11) {
                changedx(0);

                if(HelpMethods.LeftOneSideFree(hitBox.x, hitBox.y, (int) hitBox.width, (int) hitBox.height, tileData)==4)
                {
                    changedx((int)((-2.88)*(SCALE))); //walks left

                }

            }
            else if(checklr==78) {
                changedx(0);
                if(HelpMethods.RightOneSideFree(hitBox.x, hitBox.y, (int) hitBox.width, (int) hitBox.height, tileData)==5){
                    changedx((int)((8.66)*(SCALE)));   //runs right
                }

            }else if(checklr==12) {
                changedx(0);
                if(HelpMethods.RightOneSideFree(hitBox.x, hitBox.y, (int) hitBox.width, (int) hitBox.height, tileData)==5){
                    changedx((int)((2.88)*(SCALE)));   //walks right
                }

            }
            else {
                changedx(0);
            }
        }
    }


    public void setFiring(boolean firing) {
        this.firing=firing;
        if(this.firing){
            if(facingRight){
            FBC(8000); }
            else{
                FBCLeft(8001);
            }
        }
        else {
            if(facingRight){
            defaultani(); }
            else {
                defaultaniL();
            }
        }

    }

    public void setJump(boolean jump) {
        this.jump=jump;
    }
    public void deadSet(){
        inAir=false;
        flinching=false;
        poweringUp=false;
        firing=false;
    }
    public void resetAll() {
        isAlive=true;
        inAir=false;
        flinching=false;
        poweringUp=false;
        firing=false;
        currentHealth=maxHealth;
        fireValue=fireMax;
        defaultani();
        x=initialX;
        y=initialY;
//        hitBox.x= (int) (initialX+(104*SCALE));
//        hitBox.y= (int) (initialY+(43.333*SCALE));
    }
}
//  public void resetAllBooleans() {
//        left=false;
//        right=false;
//    }

