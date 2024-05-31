package utilz;

import static main.Game.*;

public class HelpMethods {
    public static int CanMoveHere(float x,float y,int width,int height,int[][] tileData){
        if (!IsSolid(x, y, tileData))/*&&(!IsSolid(x, y + height, tileData))) /*|| (!IsSolid(x, y, tileData)) || (!IsSolid(x, y + height, tileData))  )*/ {
            if (!IsSolid(x + width, y + height, tileData))/*&&(!IsSolid(x + width, y, tileData)))/*|| (!IsSolid(x + width, y + height, tileData)) || (!IsSolid(x +width, y, tileData)))*/ {
                if (!IsSolid(x + width, y, tileData))/*&&(!IsSolid(x, y, tileData))))*/{
                    if (!IsSolid(x, y + height, tileData))/*&&(!IsSolid(x + width, y + height, tileData)))) */{
                        return 100;
                    }
                }
            }
        }
                    return 0;


    }
     public static boolean CanJumpHere(float x,float y,int width,int height,int[][] tileData)
     {
         if(!IsSolid(x,y,tileData) || !IsSolid(x+width,y,tileData))
         {
             return true;
         }
         else return false;
     }
    public static int RightOneSideFree(float x, float y, int width, int height, int[][] tileData){
        if(((!IsSolid(x + width, y + height, tileData))&&(!IsSolid(x + width, y, tileData)))|| (!IsSolid(x + width, y + height, tileData)) || (!IsSolid(x +width, y, tileData)))
        {
            return 5;
        }
        return 0;
    }
    public static int LeftOneSideFree(float x, float y, int width, int height, int[][] tileData){
        if (((!IsSolid(x, y, tileData))&&(!IsSolid(x, y + height, tileData))) || (!IsSolid(x, y, tileData)) || (!IsSolid(x, y + height, tileData))  ) {
            return 4;
        }
        return 0;
    }
    public static int UpSideFree(float x, float y, int width, int height, int[][] tileData){
        if (((!IsSolid(x, y, tileData))&&(!IsSolid(x+width, y, tileData))) || (!IsSolid(x, y, tileData)) || (!IsSolid(x+width, y, tileData))  ) {
            return 44;
        }
        return 0;
    }

//public static boolean IsPseudoSolid(float x,float y,int[][] tileData)
//{
//
//}
    public static boolean IsSolid(float x,float y,int[][] tileData) {
        float xIndex=(x/TILES_SIZE);
        float yIndex=(y/TILES_SIZE);
        if (x < 0 || x >= GAME_WIDTH) {
            return true;
        }
        if (y < 0 || y >= GAME_HEIGHT){
            return true;
        }

        if (tileData[(int) yIndex][(int) xIndex]==1)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public static int GetEntityPosNextToWall( int x,int y, int width,int height,int[][] tileData) {
        float currentXTile=(x/TILES_SIZE);
        if(((IsSolid(x,y,tileData))&&(IsSolid(x,y+height,tileData)))  ||  (IsSolid(x,y,tileData)) || (IsSolid(x,y+height,tileData))){
                int tileXPos=(int)currentXTile*TILES_SIZE;
                int XOffset=(int)(TILES_SIZE-width);
                return tileXPos+XOffset+1;
        }
        else if(((IsSolid(x+width,y,tileData))&&(IsSolid(x+width,y+height,tileData))) || (IsSolid(x+width,y,tileData)) || (IsSolid(x+width,y+height,tileData)) )
        {
            int tileXposR=(int)currentXTile*TILES_SIZE;
            int XoffsetR=(int)(TILES_SIZE-width);
            return tileXposR+XoffsetR-1;

        }
        return 0;

    }

    public static int GetEntityYPosForFLoor(int x, int y, int width, int height, int[][] tileData, float airSpeed) {
        float currentYTile=(float) (y/TILES_SIZE);
        if(airSpeed>=0){
            //Falling
            int tileYPos=(int)currentYTile*TILES_SIZE;
            int YOffset=(int)(TILES_SIZE-height);
//            System.out.println(YOffset+tileYPos);
            return YOffset+tileYPos;

        }
        else {
            //Jumping
             return (int)currentYTile*TILES_SIZE;
//            int tileYPos=(int)currentYTile*TILES_SIZE;
//            int YOffset=(int)(TILES_SIZE-height);
//            return YOffset+tileYPos;
        }

    }


    public static boolean IsEntityOnFLoor(float ym,int x, int y, int width, int height, int[][] tileData) {
        float currentYTile=(float) (y/TILES_SIZE);
        int tileYPos=(int)currentYTile*TILES_SIZE;
        int YOffset=(int)(TILES_SIZE-height);
           if(!IsSolidforJump(ym,x,y+height,tileData)){
               if (!IsSolidforJump(ym,x+width,y+height,tileData)){
                   return false;
               }
           }
           return true;
    }

    private static boolean IsSolidforJump(float ym,int x, int y, int[][] tileData) {
        float xIndex=(x/TILES_SIZE);
        float yIndex=(y/TILES_SIZE);
        if (x < 0 || x >= GAME_WIDTH) {
            return true;
        }
        if (y < 0 || y >= GAME_HEIGHT){
            return true;
        }

        if (tileData[(int) yIndex][(int) xIndex]==1)
        {
            return true;
        }
//        if(ym<=246){
//            return true;
//        }
        else {
            return false;
        }


    }
//
//    private static boolean IsSolidforJump(int i, int i1, int[][] tileData) {
//        float xIndex=(i/TILES_SIZE);
//        float yIndex=(i1/TILES_SIZE);
//        if (i < 0 || i >= GAME_WIDTH) {
//            return true;
//        }
//        if (i1 < 0 || i1 >= GAME_HEIGHT){
//            return true;
//        }
//        if(i<=342){
//            return true;
//        }
//        return false;
//
//    }
}
