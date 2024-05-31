package gamestates;

import Entities.EnemyManager;
import Entities.Fireball;
import Entities.Herolvl1;
import levels.LevelManager;
import main.Game;
import ui.DemoLevelFinishOverLay;
import ui.GameOverOverlay;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static main.Game.SCALE;

public class Playing extends State implements StateMethods{
    private Herolvl1 hero1;
    private GameOverOverlay gameOverOverlay;
    private DemoLevelFinishOverLay demoLevelFinishOverLay;
    private LevelManager levelManager;
    private EnemyManager enemyManager;
    public int height=(int)(256*SCALE);
    public int width=(int)(256*SCALE);
    public boolean isApressed,isGpressed,isDpressed;
    public static boolean gameOver=false,demoWinScreen=false;
    public Playing(Game game) {
        super(game);
        initClasses();
    }

    public static void setGameOver(boolean gameOver) {
        Playing.gameOver = gameOver;
    }

    public static void setDemoWinScreen(boolean demoWinScreen) {
        Playing.demoWinScreen = demoWinScreen;
    }

    private void initClasses() {
        hero1=new Herolvl1((int)((-60*SCALE)),(int)168.3333*SCALE,width,height);
        enemyManager =new EnemyManager(this,hero1);
        levelManager=new LevelManager(game);
        hero1.loadTileData(LoadSave.GetTileData());
        gameOverOverlay=new GameOverOverlay(this);
        demoLevelFinishOverLay=new DemoLevelFinishOverLay(this);
    }
    public Herolvl1 getHero1(){
        return hero1;
    }

    @Override
    public void update() {
        levelManager.update();
        hero1.update();
        enemyManager.update();

    }

    @Override
    public void draw(Graphics g) {
        levelManager.draw1(g);
        levelManager.draw(g);
        enemyManager.renderBoss(g);
        hero1.render(g);
        if(gameOver){
            gameOverOverlay.drawG(g);
        }
        else if (demoWinScreen) {
            demoLevelFinishOverLay.drawDWS(g);
        }
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
        if(Herolvl1.isAlive && !demoWinScreen)
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_G:
                    if(!Herolvl1.isIsCrouching()) {
                        isGpressed = true;
                        hero1.setFiring(true);
                    }
                    break;
                case KeyEvent.VK_A:
                    if(!Herolvl1.isIsCrouching()) {
                        isApressed = true;
                        //System.out.println("A");
                        if (e.isShiftDown()) {
                            hero1.walkL(1);
                            hero1.setLeft(true, false);
                            // gamePanel.changedx(-8);
//                    if(isDpressed){
//                        gamePanel.getGame().getHero1().setRight(true,true);
//
//                    }

                        } else if (isDpressed) {
                            hero1.setLeft(true, true);

                        } else {
                            hero1.runL(-2);
                            hero1.setLeft(true, false);

                        }
                    }

                    break;
                case KeyEvent.VK_D:
                    if (!Herolvl1.isIsCrouching()) {
                        isDpressed = true;
//                System.out.println("D");
                        if (e.isShiftDown()) {
                            hero1.walk(-1);
                            hero1.setRight(true, false);
                            //   gamePanel.changedx(-8);
//                    if(isApressed){
//                        gamePanel.getGame().getHero1().setRight(true,true);
//
//                    }

                        }
//                else if(gamePanel.getGame().getHero1().getInAir()){
//                    gamePanel.getGame().getHero1().jumpani(62510);
//                }
                        else if (isApressed) {
                            hero1.setRight(true, true);
//                    hero1.setRight(true,false);
                        } else {
                            //   gamePanel.changedx(10);
                            hero1.run(2);
                            hero1.setRight(true, false);
                        }
                    }
                    break;
                case KeyEvent.VK_C:
                    if(!hero1.inAir)
                    { Herolvl1.setIsCrouching(true);
                        hero1.setHitBox(true);
                        if(hero1.getFacingRight()) {
                            hero1.crouch();
                        }
                        else {
                            hero1.crouchL(999);
                        }
                    }
                    break;
                case KeyEvent.VK_F:
//                isFpressed=true;
                    if(hero1.getFacingRight()) {
                        hero1.kick(-9);
                    } else if (!hero1.getFacingRight()) {
                        hero1.kickL(-619);
                    }


                    break;
                case KeyEvent.VK_SPACE:
                    if(!Herolvl1.isIsCrouching()) {
                        hero1.setJump(true);
                    }
//                gamePanel.getGame().getHero1().jumpani(62510);
                    break;
                case KeyEvent.VK_E:
                    if(!Herolvl1.isIsCrouching()){
                        hero1.setPoweringUp(true);
                        if(hero1.getFacingRight()){
                            hero1.powerHimUp(); }
                        else {
                            hero1.powerHimUpL();
                        }}
                    break;
            }

        } else if (gameOver) {
            gameOverOverlay.KeyPressed(e);
        } else if (demoWinScreen) {
            demoLevelFinishOverLay.KeyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(Herolvl1.isAlive && !demoWinScreen){
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_G:
                    if(!Herolvl1.isIsCrouching()){ hero1.setFiring(false);
                        if(hero1.getFacingRight()){
                            if(hero1.getFireValue()){
                                Herolvl1.setFireTheBall(true);
                                hero1.changeFirePower(-25);
                            }
                        }
                        else if(!hero1.getFacingRight()){
                            if(hero1.getFireValue()){
                                Herolvl1.setFireTheLeftBall(true);
                                hero1.changeFirePower(-25);
                            }
                        }
//                isGpressed=false;
//                gamePanel.getGame().getHero1().defaultani();
                        if(hero1.getFacingRight()){
                            hero1.FBCL(800); }
                        else {
                            hero1.FBCLLEFT(801);
                        }}
                    break;
                case KeyEvent.VK_A:
//                right=false;
                    if(!Herolvl1.isIsCrouching()) {
                        isApressed = false;
                        hero1.defaultaniL();
                        hero1.setLeftOnly(false);
                    }
//                  gamePanel.getGame().getHero1().setLeft(false,false);
                    break;
                case KeyEvent.VK_D:
//                right=true;
                    if(!Herolvl1.isIsCrouching()) {
                        isDpressed = false;
                        hero1.defaultani();
                        hero1.setRightOnly(false);
//                gamePanel.getGame().getHero1().setRight(false,false);
//                System.out.println("D");
//                gamePanel.changedx(10);
                    }
                    break;
                case KeyEvent.VK_C:
                    if(!hero1.inAir)
                    {        Herolvl1.setIsCrouching(false);
                        hero1.setHitBox(false);
                        if(hero1.getFacingRight()) {
                            hero1.defaultani();
                        }
                        else
                        {
                            hero1.defaultaniL();
                        }
                    }
                    break;
                case KeyEvent.VK_F:
//                isFpressed=false;
//                gamePanel.getGame().getHero1().kick(9);
//                if(!isDpressed) {
//                    gamePanel.getGame().getHero1().kick(9);
//                } else if (!isApressed) {
                    if(hero1.getFacingRight()) {
                        hero1.kick(9);
                    }
                    else if(!hero1.getFacingRight()){
                        hero1.kickL(619);
                    }
//                }

                    break;
                case KeyEvent.VK_SPACE:
                    hero1.setJump(false);
                    break;
                case KeyEvent.VK_E:
                    if(!Herolvl1.isIsCrouching()){
                        hero1.setPoweringUp(false);
                        if(hero1.getFacingRight()) {
                            hero1.defaultani();
                        }
                        else {
                            hero1.defaultaniL();
                        }}
                    break;

            }

        }
    }

    public void resetAll() {
        //reset player,enemy,level
        gameOver=false;
        demoWinScreen=false;
        hero1.resetAll();
        enemyManager.resetAll();
    }
//    public void resetAllD(){
//        demoWinScreen=false;
//        hero1.resetAll();
//        enemyManager.resetAll();
//    }
}