package demon.sprite;

import demon.base.BaseService.CreatureBaseService;
import demon.base.function.MobAI;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/*
 * GenMo demon.sprite
 * @Author:Demon
 * @Date:2021/12/28 12:13
 * @Description:
 */
public class DamageRectangleSprite extends MotionSprite
{
    private Rectangle rectangle;
    private float damage;
    private boolean isPlayer = false;

    public void action(CreatureBaseService service)
    {
        service.getElementList().forEach(creature ->
        {
            if (isPlayer)
            {
                if (creature instanceof MobAI)hurt(creature);
            }
            else ;
        });
    }

    private void hurt(Creature creature)
    {
        if (creature.isDeath()) ;
        else
        {
            creature.state.setHurt(true);
            creature.setHp(creature.getHp() - damage);
            if (creature.getHp() <= 0) creature.setDeath(true);
            Timer timer = new Timer();
            timer.schedule(new TimerTask()
            {
                @Override
                public void run()
                {
                    creature.state.setHurt(false);
                }
            }, 700);
        }
    }

    @Override
    public Rectangle getRectangle()
    {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle)
    {
        this.rectangle = rectangle;
    }

    public float getDamage()
    {
        return damage;
    }

    public void setDamage(float damage)
    {
        this.damage = damage;
    }

    public boolean isPlayer()
    {
        return isPlayer;
    }

    public void setPlayer(boolean player)
    {
        isPlayer = player;
    }
}
