package main;

import Entities.Herolvl1;
import gamestates.GameMenu;
import gamestates.GameState;
import gamestates.Playing;
import gamestates.Tutorial;
import levels.Level;
import levels.LevelManager;
import utilz.LoadSave;

import java.awt.*;

public class Game implements Runnable {
    //Creating objects of GameWindow and GamePanel
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private Playing playing;
    private GameMenu menu;
    private Tutorial tutorial;
//    private Herolvl1 hero1;
//    private LevelManager levelManager;
    private final int FPS_SET=120;
    private final int UPS_SET=250;
    public static final int TILES_DEFAULT=32;
    public static final float SCALE=1.8f; //will decide how much we want to scale everything
    public static final int TILES_IN_WIDTH=26;
    public static final int TILES_IN_HEIGHT=14;
    public static final int TILES_SIZE=(int)(TILES_DEFAULT*SCALE);
    public static final int GAME_WIDTH=TILES_SIZE*TILES_IN_WIDTH;
    public static final int GAME_HEIGHT=TILES_SIZE*TILES_IN_HEIGHT;
    public int height=(int)(256*SCALE);
    public int width=(int)(256*SCALE);

    public Game(){
        initClasses();
        gamePanel=new GamePanel(this);
        gameWindow=new GameWindow(gamePanel);
        gamePanel.requestFocus(); //Method used for keys to run
        gamePanel.requestFocus();
        startGameLoop();

    }

    private void initClasses() {
        menu=new GameMenu(this);
        playing=new Playing(this);
        tutorial=new Tutorial(this);
//        hero1=new Herolvl1((int)((-60*SCALE)),(int)136*SCALE,width,height);
//        levelManager=new LevelManager(this);
//        hero1.loadTileData(LoadSave.GetTileData());
    }

    public void startGameLoop(){
        gameThread=new Thread(this);
        gameThread.start();
    }
    private void update() {
//        gamePanel.updateGame();

        switch (GameState.state){
            case MENU -> {
                menu.update();
            }
            case PLAYING -> {
                playing.update();
//                levelManager.update();
//                hero1.update();
            }
            case TUTORIAL -> {
                tutorial.update();
            }
            case QUIT -> {
                System.exit(0);
            }

        }

    }
//    public void windowFocusLost(){
//        hero1.resetAllBooleans();
//    }
    public void render(Graphics g)
    {

        switch (GameState.state){
            case MENU -> {
                menu.draw(g);
            }
            case PLAYING -> {
                playing.draw(g);
//                levelManager.draw1(g);
//                levelManager.draw(g);
//                hero1.render(g);
            }
            case TUTORIAL -> {
                tutorial.draw(g);
            }
        }
    }

    @Override

    public void run() {   //method override from runnable which will help us run the code on separate thread
//inside this method will be our gameloop
        double timePerFrame= 1000000000/FPS_SET;//stores duration each frame should last in nano seconds
        double timePerUpdate= 1000000000/UPS_SET; //time of frequency
//        long lastFrame=System.nanoTime();
//        long now=System.nanoTime();
        long previousTime=System.nanoTime();
        int frames=0,updates=0;
        long lastCheck=System.currentTimeMillis();
        double deltaU=0;
        double deltaF=0;
      while (true){
//          now=System.nanoTime();
          long currentTime=System.nanoTime();
/*the way we are going to update is to check if deltaU >= 1, it will be 1 or more than 1
  when duration since last update is equal or more than timePerUpdate*/

          deltaU+=(currentTime-previousTime)/timePerUpdate;
          deltaF+=(currentTime-previousTime)/timePerFrame;
          previousTime=currentTime;
          if(deltaU>=1)
          {  update();
              updates++;
               deltaU--;
          }
          if(deltaF>=1)
          {
              gamePanel.repaint();
              frames++;
              deltaF--;
          }

//          Game loop before update:
//          if(now-lastFrame >= timePerFrame) { //this condition checks if enough time has passed since last frame and if yes , we update the frames
//              gamePanel.repaint();
//              lastFrame=now;
//              frames++;
//          }

          if(System.currentTimeMillis()-lastCheck >= 1000)
          {
              lastCheck=System.currentTimeMillis();
//              System.out.println("FPS:"+frames +" UPS:"+updates);
              frames=0;
              updates=0;
          }
      }
    }
    public GameMenu getMenu(){
        return menu;
    }
    public Playing getPlaying(){
        return playing;
    }
    public Tutorial getTutorial() { return tutorial; }
//public Herolvl1 getHero1(){
//        return hero1;
//}

}
