package demon.sprite;

import demon.base.BaseService.CreatureBaseService;
import demon.base.function.Audio;
import demon.base.function.MobAI;
import demon.util.CommonUtils;
import demon.util.GetService;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

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
    private long tick;
    private boolean isPlayer = false;

    DamageRectangleSprite()
    {
    }

    public long getTick()
    {
        return tick;
    }

    public void setTick(long tick)
    {
        this.tick = tick;
    }

    DamageRectangleSprite(Rectangle rectangle, float damage, long tick)
    {
        this.rectangle = rectangle;
        this.damage = damage;
        this.tick = tick;
    }

    public void action(CreatureBaseService service, long delay)
    {
        service.getElementList().forEach(creature ->
        {
            DamageRectangleSprite sprite = this;
            new Timer().schedule(new TimerTask()
            {
                @Override
                public void run()
                {
                    new Timer().schedule(new TimerTask()
                    {
                        @Override
                        public void run()
                        {
                            GetService.getDamage().remove(sprite);
                            cancel();
                        }
                    }, 24);
                    if (isPlayer)
                    {
                        if (creature instanceof MobAI && creature.getRectangle().intersects(rectangle))
                        {
                            hurt(creature);
                        }
                    } else
                    {
                        if (creature instanceof Player && creature.getRectangle().intersects(rectangle))
                        {
                            hurt(creature);
                        }
                    }
                    cancel();
                }
            }, delay);

        });
    }

    private void hurt(Creature creature)
    {
        if (creature.isDeath()) ;
        else if (!creature.state.isUnbeatable())
        {
            creature.state.setHurt(true);
            creature.state.setUnbeatable(true);
            creature.beHurt(damage);
            if (creature instanceof Golem)
            {
                if (CommonUtils.nextInt(0, 10) > 5) Audio.GOLEM_HURT1.play();
                else Audio.GOLEM_HURT2.play();
            }
            if (creature instanceof Player)
            {
                Audio.PLAYER_HURT.play();
            }
            Timer timer = new Timer();
            timer.schedule(new TimerTask()
            {
                @Override
                public void run()
                {
                    creature.state.setHurt(false);
                    creature.state.setUnbeatable(false);
                    cancel();
                }
            }, 300);
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

    public void setRectangle(int x, int y)
    {
        this.rectangle.x = x;
        this.rectangle.y = y;
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
