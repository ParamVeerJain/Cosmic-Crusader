package utilz;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static main.Game.*;

public class LoadSave {
 //   public static BufferedImage h1idle=null, h1walk=null, h1run=null, h1airidle=null, h1jump1=null, h1jump2=null, h1land=null, h1crouch=null, h1kick=null, h1flykick=null;

    public static BufferedImage GetIdle() {
        BufferedImage h1idle=null;
        InputStream is = LoadSave.class.getResourceAsStream("/HeroSprites/h1idlefinal.png");
        try {
            h1idle = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1idle;
    } public static BufferedImage GetIdleL() {
        BufferedImage h1idlel=null;
        InputStream isl = LoadSave.class.getResourceAsStream("/HeroSprites/h1idleL.png");
        try {
            h1idlel = ImageIO.read(isl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                isl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1idlel;
    }

    public static BufferedImage GetWalk() {
        BufferedImage h1walk=null;
        InputStream id = LoadSave.class.getResourceAsStream("/HeroSprites/h1walk.png");
        try {
            h1walk = ImageIO.read(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                id.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1walk;
    } public static BufferedImage GetWalkL() {
        BufferedImage h1walkl=null;
        InputStream iddd = LoadSave.class.getResourceAsStream("/HeroSprites/h1walkl.png");
        try {
            h1walkl = ImageIO.read(iddd);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                iddd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1walkl;
    }

    public static BufferedImage GetRun() {
        BufferedImage h1run=null;
        InputStream ig = LoadSave.class.getResourceAsStream("/HeroSprites/h1runnew.png");
        try {
            h1run = ImageIO.read(ig);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ig.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1run;
    }
    public static BufferedImage GetRunL() {
        BufferedImage h1runlL=null;
        InputStream igll = LoadSave.class.getResourceAsStream("/HeroSprites/h1runl22.png");
        try {
            h1runlL = ImageIO.read(igll);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                igll.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1runlL;
    }


//    public static BufferedImage GetAirIdle() {
//
//    }

    public static BufferedImage GetJ1() {
        BufferedImage h1jump1=null;
        InputStream ih = LoadSave.class.getResourceAsStream("/HeroSprites/h1jump1.png");
        try {
            h1jump1 = ImageIO.read(ih);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ih.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         return h1jump1;
    }

    public static BufferedImage GetJ2() {
        BufferedImage h1jump2=null;
        InputStream il = LoadSave.class.getResourceAsStream("/HeroSprites/h1jump2.png");
        try {
            h1jump2 = ImageIO.read(il);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                il.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return h1jump2;
        }
    }  public static BufferedImage GetJ2L() {
        BufferedImage h1jump2=null;
        InputStream il = LoadSave.class.getResourceAsStream("/HeroSprites/h1jumpL.png");
        try {
            h1jump2 = ImageIO.read(il);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                il.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return h1jump2;
        }
    }
    public static BufferedImage GetAA() {
        BufferedImage h1AA=null;
        InputStream ila = LoadSave.class.getResourceAsStream("/HeroSprites/h1airidle.png");
        try {
            h1AA = ImageIO.read(ila);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ila.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return h1AA;
        }
    }

//    public static BufferedImage GetLand() {
//
//    }

    public static BufferedImage GetKick() {
        BufferedImage h1kick=null;
        InputStream iy = LoadSave.class.getResourceAsStream("/HeroSprites/h1kick.png");
        try {
            h1kick = ImageIO.read(iy);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                iy.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1kick;
    }

    public static BufferedImage GetKickL() {
        BufferedImage h1lkick=null;
        InputStream iu = LoadSave.class.getResourceAsStream("/HeroSprites/h1kickl.png");
        try {
            h1lkick = ImageIO.read(iu);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                iu.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return h1lkick;
        }
    }


    public static BufferedImage GetCrouch() {
        BufferedImage h1crouch=null;
        InputStream im = LoadSave.class.getResourceAsStream("/HeroSprites/h1crouch.png");
        try {
            h1crouch = ImageIO.read(im);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                im.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1crouch;
    } public static BufferedImage GetLanding() {
        BufferedImage h1land=null;
        InputStream imlll = LoadSave.class.getResourceAsStream("/HeroSprites/h1land.png");
        try {
            h1land = ImageIO.read(imlll);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imlll.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1land;
    }
    public static BufferedImage GetCrouchL() {
        BufferedImage h1crouchl=null;
        InputStream imc = LoadSave.class.getResourceAsStream("/HeroSprites/h1crouchl.png");
        try {
            h1crouchl = ImageIO.read(imc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1crouchl;
    }
    public static BufferedImage GetFireCharge() {
        BufferedImage h1FC=null;
        InputStream imfc = LoadSave.class.getResourceAsStream("/HeroSprites/h1fireball.png");
        try {
            h1FC = ImageIO.read(imfc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imfc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1FC;
    } public static BufferedImage GetFireChargeL() {
        BufferedImage h1FCl=null;
        InputStream imfcl = LoadSave.class.getResourceAsStream("/HeroSprites/h1fireballL.png");
        try {
            h1FCl = ImageIO.read(imfcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imfcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1FCl;
    }
    public static BufferedImage GetFireLaunch() {
        BufferedImage h1FCL=null;
        InputStream imfcl = LoadSave.class.getResourceAsStream("/HeroSprites/h1launch.png");
        try {
            h1FCL = ImageIO.read(imfcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imfcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1FCL;
    } public static BufferedImage GetFireLaunchL() {
        BufferedImage h1FCLl=null;
        InputStream imfcll = LoadSave.class.getResourceAsStream("/HeroSprites/h1launchL.png");
        try {
            h1FCLl = ImageIO.read(imfcll);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imfcll.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1FCLl;
    }
    public static BufferedImage GetPowerUp() {
        BufferedImage h1FCLP=null;
        InputStream imfcla = LoadSave.class.getResourceAsStream("/HeroSprites/h1powerup1.png");
        try {
            h1FCLP = ImageIO.read(imfcla);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imfcla.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1FCLP;
    }
    public static BufferedImage GetHeroflinch() {
        BufferedImage h1FCLP=null;
        InputStream imfcla = LoadSave.class.getResourceAsStream("/HeroSprites/heroflinch.png");
        try {
            h1FCLP = ImageIO.read(imfcla);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imfcla.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1FCLP;
    }
    public static BufferedImage GetHeroflinchL() {
        BufferedImage h1FCLP=null;
        InputStream imfcla = LoadSave.class.getResourceAsStream("/HeroSprites/heroflinchL.png");
        try {
            h1FCLP = ImageIO.read(imfcla);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imfcla.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1FCLP;
    }
    public static BufferedImage GetHeroKO() {
        BufferedImage h1FCLP=null;
        InputStream imfcla = LoadSave.class.getResourceAsStream("/HeroSprites/KO1.png");
        try {
            h1FCLP = ImageIO.read(imfcla);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imfcla.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1FCLP;
    }
    public static BufferedImage GetHeroKO2() {
        BufferedImage h1FCLP=null;
        InputStream imfcla = LoadSave.class.getResourceAsStream("/HeroSprites/KO2.png");
        try {
            h1FCLP = ImageIO.read(imfcla);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imfcla.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1FCLP;
    }
    public static BufferedImage GetGameOverScreen() {
        BufferedImage h1FCLP=null;
        InputStream imfcla = LoadSave.class.getResourceAsStream("/GameOverScreen.png");
        try {
            h1FCLP = ImageIO.read(imfcla);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imfcla.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1FCLP;
    }    public static BufferedImage DemoWinScreen() {
        BufferedImage h1FCLP=null;
        InputStream imfcla = LoadSave.class.getResourceAsStream("/WinScreen.png");
        try {
            h1FCLP = ImageIO.read(imfcla);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imfcla.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1FCLP;
    }
    public static BufferedImage GetHC() {
        BufferedImage h1hc=null;
        InputStream imfclah = LoadSave.class.getResourceAsStream("/HomeScreenNew.png");
        try {
            h1hc = ImageIO.read(imfclah);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imfclah.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1hc;
    }
    public static BufferedImage GetHC2() {
        BufferedImage h1h2=null;
        InputStream imfclah2 = LoadSave.class.getResourceAsStream("/HomeScreenNew1.png");
        try {
            h1h2 = ImageIO.read(imfclah2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imfclah2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1h2;
    }    public static BufferedImage GetMenuButtons() {
        BufferedImage h1h2=null;
        InputStream imfclah2 = LoadSave.class.getResourceAsStream("/button_atlas.png");
        try {
            h1h2 = ImageIO.read(imfclah2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                imfclah2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1h2;
    }
    public static BufferedImage GetLevelSprite() {
        BufferedImage h1lvlsprite=null;
        InputStream iqq = LoadSave.class.getResourceAsStream("/LevelSprites/demo map2.png");
        try {
            h1lvlsprite = ImageIO.read(iqq);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                iqq.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1lvlsprite;
    }
    public static BufferedImage GetLevelSprite1() {
        BufferedImage h1lvlsprite1=null;
        InputStream ipp = LoadSave.class.getResourceAsStream("/LevelSprites/map.png");
        try {
            h1lvlsprite1 = ImageIO.read(ipp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ipp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1lvlsprite1;
    }
    public static BufferedImage GetHomeScreenBG() {
        BufferedImage h1lvlsprite1=null;
        InputStream ipp = LoadSave.class.getResourceAsStream("/LevelSprites/map.png");
        try {
            h1lvlsprite1 = ImageIO.read(ipp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ipp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return h1lvlsprite1;
    }
    public static BufferedImage GetLevelFBS() {
        BufferedImage fb=null;
        InputStream fbc = LoadSave.class.getResourceAsStream("/HeroSprites/FireballRN.png");
        try {
            fb = ImageIO.read(fbc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fbc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fb;
    }  public static BufferedImage GetLevelFBSLEFT() {
        BufferedImage fb=null;
        InputStream fbc = LoadSave.class.getResourceAsStream("/HeroSprites/FireballRNL.png");
        try {
            fb = ImageIO.read(fbc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fbc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fb;
    }
    public static BufferedImage GetLevelFBSL() {
        BufferedImage fbl=null;
        InputStream fbcl = LoadSave.class.getResourceAsStream("/HeroSprites/FireballRl.png");
        try {
            fbl = ImageIO.read(fbcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fbcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fbl;
    } public static BufferedImage GetPowerUpL() {
        BufferedImage fbl=null;
        InputStream fbcl = LoadSave.class.getResourceAsStream("/HeroSprites/h1powerupL.png");
        try {
            fbl = ImageIO.read(fbcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fbcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fbl;
    }
    public static BufferedImage GetHealthBar() {
        BufferedImage hbl=null;
        InputStream hbcl = LoadSave.class.getResourceAsStream("/HeroSprites/HeroHealthBar.png");
        try {
            hbl = ImageIO.read(hbcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                hbcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hbl;
    }
    public static BufferedImage GetBossHealthBar() {
        BufferedImage bhbl=null;
        InputStream bhbcl = LoadSave.class.getResourceAsStream("/BossSprites/BossHealthBar.png");
        try {
            bhbl = ImageIO.read(bhbcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bhbcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bhbl;
    }
    public static BufferedImage GetBossIdleL() {
        BufferedImage bhbl=null;
        InputStream bhbcl = LoadSave.class.getResourceAsStream("/BossSprites/BossIdleL.png");
        try {
            bhbl = ImageIO.read(bhbcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bhbcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bhbl;
    }
    public static BufferedImage GetBossWalkL() {
        BufferedImage bhbl=null;
        InputStream bhbcl = LoadSave.class.getResourceAsStream("/BossSprites/BossWalkL.png");
        try {
            bhbl = ImageIO.read(bhbcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bhbcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bhbl;
    }
    public static BufferedImage GetBossA2L() {
        BufferedImage bhbl=null;
        InputStream bhbcl = LoadSave.class.getResourceAsStream("/BossSprites/bossA2L.png");
        try {
            bhbl = ImageIO.read(bhbcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bhbcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bhbl;
    }
    public static BufferedImage GetBossA1L() {
        BufferedImage bhbl=null;
        InputStream bhbcl = LoadSave.class.getResourceAsStream("/BossSprites/bossattackL.png");
        try {
            bhbl = ImageIO.read(bhbcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bhbcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bhbl;
    } public static BufferedImage GetBossFlinchL() {
        BufferedImage bhbl=null;
        InputStream bhbcl = LoadSave.class.getResourceAsStream("/BossSprites/bossFlinchL.png");
        try {
            bhbl = ImageIO.read(bhbcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bhbcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bhbl;
    }
    public static BufferedImage GetBossIdle() {
        BufferedImage bl=null;
        InputStream bcl = LoadSave.class.getResourceAsStream("/BossSprites/bossidle.png");
        try {
            bl = ImageIO.read(bcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bl;
    }
    public static BufferedImage GetBossA1() {
        BufferedImage abl=null;
        InputStream abcl = LoadSave.class.getResourceAsStream("/BossSprites/bossattack.png");
        try {
            abl = ImageIO.read(abcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                abcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return abl;
    }
    public static BufferedImage GetBossA2() {
        BufferedImage a2bl=null;
        InputStream a2bcl = LoadSave.class.getResourceAsStream("/BossSprites/bossattack2.png");
        try {
            a2bl = ImageIO.read(a2bcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                a2bcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return a2bl;
    }
    public static BufferedImage GetBossWalk() {
        BufferedImage ba2bl=null;
        InputStream ba2bcl = LoadSave.class.getResourceAsStream("/BossSprites/bosswalk.png");
        try {
            ba2bl = ImageIO.read(ba2bcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ba2bcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ba2bl;
    }
    public static BufferedImage GetBossFlinch() {
        BufferedImage baf2bl=null;
        InputStream baf2bcl = LoadSave.class.getResourceAsStream("/BossSprites/bossflinch.png");
        try {
            baf2bl = ImageIO.read(baf2bcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                baf2bcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return baf2bl;
    }
    public static BufferedImage GetBossDies() {
        BufferedImage dbaf2bl=null;
        InputStream dbaf2bcl = LoadSave.class.getResourceAsStream("/BossSprites/bossisdead.png");
        try {
            dbaf2bl = ImageIO.read(dbaf2bcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                dbaf2bcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dbaf2bl;
    }  public static BufferedImage GetFireBallBar() {
        BufferedImage dbaf2bl=null;
        InputStream dbaf2bcl = LoadSave.class.getResourceAsStream("/HeroSprites/FireballBar1.png");
        try {
            dbaf2bl = ImageIO.read(dbaf2bcl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                dbaf2bcl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dbaf2bl;
    }

    public static BufferedImage[][] GetLevelData() {
//        int[][] lvlData = new int[TILES_IN_HEIGHT][TILES_IN_WIDTH];
        BufferedImage img=GetLevelSprite();
        BufferedImage[][] imgv = new BufferedImage[TILES_IN_HEIGHT][TILES_IN_WIDTH];
        for (int i = 0; i < TILES_IN_HEIGHT; i++) {
            for (int j = 0; j < TILES_IN_WIDTH; j++) {
                int x = j * 32;
                int y = i * 32;
                if (x + 32<= img.getWidth() && y + 32 <= img.getHeight()) {
                    imgv[i][j] = img.getSubimage(x, y, 32, 32);
                }
            }
        }
        return imgv;
    }
    public static int[][] GetTileData() {
        int[][] tileData={
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
        return tileData;
    }
//    public static BufferedImage GetIdle(){
//
//    }
}
