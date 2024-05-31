package Entities;

import static utilz.Constants.EnemyConstants.*;

public class Enemy extends Entity{
    private int aniIndex,aniTick,aniSpeed=19,enemyState,requiredBossIndex;
    public Enemy(){

    }
    public Enemy(float x,float y,int width,int height){
//        super(x,y,width,height);
//        initHitBox();
    }
    private void bossAnimation(){
        aniTick++;
        if(aniTick>=aniSpeed){
            aniTick=0;
            aniIndex++;
            if (aniIndex>=BOSS_DEAD){
                aniIndex=0;
            }
        }
    }
    public int getAniIndex(){
        return aniIndex;
    }
    public void update(){
        bossAnimation();
    }
}
