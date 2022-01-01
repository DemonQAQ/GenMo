package demon.sprite;

import demon.util.GetService;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/*
 * GenMo demon.sprite
 * @Author:Demon
 * @Date:2021/12/30 0:15
 * @Description:
 */
public class Effect extends MotionSprite
{
    private DamageRectangleSprite damageRectangleSprite;
    private long delay;
    private long period;

    Effect(DamageRectangleSprite damageRectangleSprite, long delay, Image image, int width,
           int height)
    {
        this.Image = image;
        this.delay = delay;
        this.damageRectangleSprite = damageRectangleSprite;
        this.x = damageRectangleSprite.x;
        this.y = damageRectangleSprite.y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void action()
    {
        damageRectangleSprite.x += damageRectangleSprite.xSpeed;
        damageRectangleSprite.y += damageRectangleSprite.ySpeed;
        damageRectangleSprite.setRectangle(damageRectangleSprite.x,damageRectangleSprite.y);
        this.x = damageRectangleSprite.x;
        this.y = damageRectangleSprite.y;
        GetService.getDamage().add(damageRectangleSprite);
    }

    public DamageRectangleSprite getDamageRectangleSprite()
    {
        return damageRectangleSprite;
    }

    public void setDamageRectangleSprite(DamageRectangleSprite damageRectangleSprite)
    {
        this.damageRectangleSprite = damageRectangleSprite;
    }


}
