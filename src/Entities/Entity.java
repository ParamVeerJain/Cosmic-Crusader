package Entities;

import java.awt.*;

import static main.Game.*;

public abstract class Entity {
   protected float x,y;
   protected int width,height;
   protected int crouching=0;
   protected Rectangle hitBox;
   protected static Rectangle hitBoxBoss;
   protected Rectangle hitBoxFireBall;
   protected Rectangle hitBoxFireBallL;
//   protected Rectangle hitBox;
    public Entity(){}
   public Entity(float x,float y,int width,int height)
   {
       this.x=x;
       this.y=y;
       this.width=width;
       this.height=height;
//       initHitBox();
//       initBossHitBox();
   }   public Entity(float x,float y,int width,int height,float a)
   {
       this.x=x;
       this.y=y;
       this.width=width;
       this.height=height;
//       initHitBox();
       initBossHitBox();
   }
    public Entity(float x,float y,int width,int height,int a) {
        this.x = x;
        this.y = y;
        this.width = (int) (width/1.8);
        this.height = (int) (height/2.5);
        initFireBallHitBox();
    } public Entity(float x,float y,int width,int height,int a,int b) {
        this.x = x;
        this.y = y;
        this.width = (int) (width/1.8);
        this.height = (int) (height/2.5);
        initFireBallLHitBox();
    }

    private void initFireBallLHitBox() {
        hitBoxFireBallL=new Rectangle((int)(x),(int)y,width,height);
    }

    protected void initFireBallHitBox(){
           hitBoxFireBall=new Rectangle((int)(x),(int)y,width,height);
    }
    protected void drawFireBallHitBox(Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect((int) (hitBoxFireBall.x+(12.888*SCALE)), (int) (hitBoxFireBall.y+(20.777*SCALE)),hitBoxFireBall.width, hitBoxFireBall.height);
    } protected void drawFireBallLHitBox(Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect((int) (hitBoxFireBallL.x+(17.888*SCALE)), (int) (hitBoxFireBallL.y+(20.777*SCALE)),hitBoxFireBallL.width, hitBoxFireBallL.height);
    }
    protected void initBossHitBox() {
        hitBoxBoss=new Rectangle((int)x,(int)y,width,height);
    }

    protected void drawHitBOx(Graphics g){
       g.setColor(Color.WHITE);
       g.drawRect(hitBox.x,hitBox.y, hitBox.width, hitBox.height);
//       g.drawRect(hitBoxBoss.x,hitBoxBoss.y, hitBoxBoss.width, hitBoxBoss.height);
}
protected void drawBossHitBox(Graphics g){
    g.setColor(Color.WHITE);
    g.drawRect(hitBoxBoss.x,hitBoxBoss.y, hitBoxBoss.width, hitBoxBoss.height);
}
//public void drawHitbox1(Graphics g){
//       g.setColor(Color.BLACK);
//        g.drawRect(hitBox1.x,hitBox1.y,hitBox1.width,hitBox1.height);
//   }
    protected void initHitBox() {
       hitBox=new Rectangle((int)((x+(104*SCALE))),(int)((y+(43.33*SCALE))),(int)width/5,(int)((height/3)));
       hitBoxBoss=new Rectangle(0,(int)(296.66*SCALE),GAME_WIDTH,100);
    }
    protected void updateHitBox()
    {
        hitBox.x=(int)((x+(104*SCALE)));
        if(!Herolvl1.isIsCrouching()){
        hitBox.y=(int)((y+(43.33*SCALE)));
        crouching=0;
        }
        else if(Herolvl1.isIsCrouching()){
            if(crouching==0){
            hitBox.y= (int) ((hitBox.y+(hitBox.height/2))+(5.55*SCALE));
              crouching++;
            }
        }
//        System.out.println("X="+hitBox.x +"Y="+hitBox.y);

    }
    protected void updateBossHitBox(float x){
//        System.out.println("I'm in");
        hitBoxBoss.x=(int)x;
        hitBoxBoss.y=(int)y;
    }
    public Rectangle getHitBox()
    {
        return hitBox;
    }
    //public static Rectangle getHitBox1()
//    {
//        return hitBox1;
//    }
}
