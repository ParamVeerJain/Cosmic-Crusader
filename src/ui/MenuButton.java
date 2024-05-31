package ui;

import gamestates.GameMenu;
import gamestates.GameState;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.UI.Buttons.*;

public class MenuButton {
    private int xPos,yPos,rowIndex,index;
    private boolean mouseOver, mousePressed;
    private GameState state;
    private BufferedImage[] imgs;
    BufferedImage tempImg= LoadSave.GetMenuButtons();
    private Rectangle bounds;
    public MenuButton(int xPos, int yPos, int rowIndex, GameState state){
        this.xPos=xPos;
        this.yPos=yPos;
        this.rowIndex=rowIndex;
        this.state=state;
        loadButtons();
        initBounds();
    }

    private void initBounds() {
        bounds=new Rectangle(xPos,yPos,B_WIDTH,B_HEIGHT);
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public void applyGameState(){
        GameState.state=state;
    }
    public void resetBools(){
        mousePressed=false;
        mouseOver=false;
    }

    private void loadButtons() {
        imgs=new BufferedImage[3];
        for(int i=0;i< imgs.length;i++){
            imgs[i]=tempImg.getSubimage(i*B_WIDTH_DEFAULT,(rowIndex)*B_HEIGHT_DEFAULT,B_WIDTH_DEFAULT,B_HEIGHT_DEFAULT);
        }
    }
    public void update(){
        index=0;
        if(mouseOver){
            index=1;
        }
        if(mousePressed){
            index=2;
        }
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void drawButtons(Graphics g){
      g.drawImage(imgs[index],xPos,yPos,B_WIDTH,B_HEIGHT,null);
    }
}