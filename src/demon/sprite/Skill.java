package demon.sprite;

import demon.util.CommonUtils;
import demon.util.Keys;

import java.awt.*;

/*
 * GenMo demon.sprite
 * @Author:Demon
 * @Date:2021/12/27 23:36
 * @Description:
 */
public abstract class Skill extends MotionSprite
{
     protected Player player;
     protected DamageRectangleSprite damageRectangleSprite;
     protected boolean endFlag = false;

     protected Skill()
     {
     }

     protected Skill(String name)
     {
          this.Image= CommonUtils.getImage(name);
     }

     public DamageRectangleSprite getDamageRectangleSprite()
     {
          return damageRectangleSprite;
     }

     public void setDamageRectangleSprite(DamageRectangleSprite damageRectangleSprite)
     {
          this.damageRectangleSprite = damageRectangleSprite;
     }


     public Player getPlayer()
     {
          return player;
     }

     public void action(Creature creature)
     {
     }

//     public void setKeys(Keys... keys)
//     {
//          this.keys=keys;
//     }

//     protected boolean judgeKeys()
//     {
//          for (Keys key:keys)
//          {
//               if (!key.use())return false;
//          }
//          return true;
//     }
     protected void effect(Creature sprites){}
}
