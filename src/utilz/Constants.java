package utilz;

import static main.Game.SCALE;

public class Constants {
public static class UI{
    public static class Buttons{
        public static final int B_WIDTH_DEFAULT=140;
        public static final int B_HEIGHT_DEFAULT=56;
        public static final int B_WIDTH= (int) (B_WIDTH_DEFAULT*SCALE);
        public static final int B_HEIGHT= (int) (B_HEIGHT_DEFAULT*SCALE);
    }
}
    public static class EnemyConstants{
        public static final int BOSS_IDLE=6;
        public static final int BOSS_WALK=12;
        public static final int BOSS_FLINCH=5;
        public static final int BOSS_A1=14;
        public static final int BOSS_A2=19;
        public static final int BOSS_DEAD=20;
        public static final float BOSS_WIDTH_DEFAULT=256;
        public static final int BOSS_WIDTH= (int) (256*SCALE);
        public static final float BOSS_HEIGHT_DEFAULT=256;
        public static final int BOSS_HEIGHT= (int) (256*SCALE);
    }
    public static class PlayerConstants {   //inner class
        public static final int WALK = 26;
        public static final int IDLE = 26;
        public static final int RUN = 22;
        public static final int LAND = 3;
        public static final int KUNGFU = 26;
        public static final int KICK = 19;
        public static final int J1 = 26;
        public static final int J2 = 26;
        public static final int POWER_UP = 26;
        public static final int CROUCH = 26;
        public static final int AIRIDLE = 2;
        public static final int FIREBALLCHARGE=7;
        public static final int LAUNCHFB=12;
        public static final int HERO_FLINCH=11;
        public static final int HERO_KO=4;
        public static final int HERO_KO2=2;

    }
}
