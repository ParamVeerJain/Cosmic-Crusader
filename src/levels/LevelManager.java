package levels;

import Entities.Entity;
import main.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static main.Game.*;

public class LevelManager {
    private Game game;
//    private Entity entity;
//    private BufferedImage[] levelSprite;
    private BufferedImage levelSprite;
    private BufferedImage rslevelSprite;
    private BufferedImage[][] tiledMap;
//    private Rectangle hb1=Entity.getHitBox1();
    private Level levelOne;

    public LevelManager(Game game) {
        this.game = game;
        levelOne=new Level(LoadSave.GetTileData());
//        importOutsideSprites();
//    levelSprite=LoadSave.GetLevelSprite();
    rslevelSprite=LoadSave.GetLevelSprite1();
        tiledMap=LoadSave.GetLevelData();

    }



    public void draw(Graphics g) {
        for (int i=0;i<TILES_IN_HEIGHT;i++) {
            for (int j = 0; j < TILES_IN_WIDTH; j++) {
                g.drawImage(tiledMap[i][j],j*TILES_SIZE ,i*TILES_SIZE  ,(int)(TILES_SIZE), (int)(TILES_SIZE),null);
            }
        }
//                int index=levelOne.getSpriteIndex(j,i);
//                int index2=levelOne.getSpriteIndex2(j,i);
//                g.drawImage(levelSprite[index], TILES_SIZE*j, TILES_SIZE*i,TILES_SIZE,TILES_SIZE, null);
//                g.drawImage(levelSprite, 0, 0,GAME_WIDTH,GAME_HEIGHT, null);
//        g.setColor(Color.WHITE);
//        g.drawRect(hb1.x,hb1.y,hb1.width,hb1.height);

            }
            public void draw1(Graphics g) {
//        for (int i=0;i<TILES_IN_HEIGHT;i++){
//            for(int j=0;j<TILES_IN_WIDTH;j++){
//                int index=levelOne.getSpriteIndex(j,i);
//                int index2=levelOne.getSpriteIndex2(j,i);
//                g.drawImage(levelSprite[index], TILES_SIZE*j, TILES_SIZE*i,TILES_SIZE,TILES_SIZE, null);
                g.drawImage(rslevelSprite, 0, 0,GAME_WIDTH,GAME_HEIGHT, null);

            }



    public void update() {

    }
//    public Level getCurrentLevel(){
//        return levelOne;
//    }
}

