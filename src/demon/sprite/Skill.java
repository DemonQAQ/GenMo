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
     protected Mob mob;
     protected DamageRectangleSprite damageRectangleSprite;
     private Effect effect;

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

     public Effect getEffect()
     {
          return effect;
     }

     public void setEffect(Effect effect)
     {
          this.effect = effect;
     }

     protected void effect(Creature sprites){}
}
