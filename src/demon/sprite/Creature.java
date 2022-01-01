package demon.sprite;

import demon.base.function.CreatureState;
import demon.base.function.Direction;
import demon.base.function.Element;
import demon.util.CommonUtils;
import demon.util.FlipImage;
import demon.util.GetService;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/*
 * GenMo demon.base
 * @Author:Demon
 * @Date:2021/12/27 9:01
 * @Description:
 */
public class Creature extends GravityMotionSprite
{
    protected float hp = 50;
    protected float defence;
    protected boolean death = false;
    public CreatureState state;
    public int crashBoxWidth, crashBoxHeight;

    Creature()
    {
    }

    Creature(int x, int y)
    {
        super(x, y);
        Element ann = this.getClass().getAnnotation(Element.class);
        this.crashBoxWidth = ann.crashWidth();
        this.crashBoxHeight = ann.crashHeight();
        this.hp = ann.hp();
        this.defence = ann.defense();
        this.direction = ann.direction();
    }

    public void beHurt(float damage)
    {
        this.hp -= damage;
        if (hp <= 0) this.setDeath(true);
    }

    public void crash(Creature obj)
    {
//        if (Math.abs(this.getX() - obj.getX()) > Math.abs(this.getX() - (obj.getX() + (obj.direction == Direction.RIGHT ?
//                obj.getXSpeed() : -obj.getXSpeed()))))
//        {
//            if (obj.state.isFly())
//            {
//                obj.setYSpeed(20);
//                if (obj.state.isRun()) obj.setXSpeed(-10);
//                else
//                    obj.x += this.x + this.crashBoxWidth / 2 > obj.x + obj.crashBoxWidth / 2 ? -20 : 20;
//            } else if (obj.state.isRun())
//            {
//                obj.state.setRun(false);
//                obj.state.setIdle(true);
//                obj.setXSpeed(-8);
//            }
//        }
//        if ((this.x < obj.x + obj.crashBoxWidth / 2) && (this.x + this.crashBoxWidth > obj.x + obj.crashBoxWidth / 2))
//        {
//            if ((obj.getY() + obj.crashBoxHeight) >= this.y)
//            {
//                obj.setYSpeed(60);
//                if (obj.state.isRun()) obj.setXSpeed(-20);
//                else
//                    obj.x += this.x + this.crashBoxWidth / 2 > obj.x + obj.crashBoxWidth / 2 ? -20 : 20;
//            }
//        }
//        左
        Rectangle myself = getRectangle();
        Rectangle obj_ = obj.getRectangle();
        if (obj.state.isFly())
        {
            if ((obj_.getY()+obj_.height)>myself.getY())
            {
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
                                obj.setY(obj.y-20);
                                obj.setX(obj.x + (myself.getX()>obj_.getX()?-30:30));
                                cancel();
                            }
                        }, 25);
                        cancel();
                    }
                }, 75);
            }
        }
        else if (obj.state.isRun())
        {
            obj.setXSpeed(-10);
        }
        else if (obj.state.isIdle())
        {
            obj.setX(obj.x + (myself.getX()>obj_.getX()?-30:30));
        }

    }

    void checkState()
    {
    }


    public boolean intersects(Creature obj)
    {
        return getRectangle().intersects(obj.getRectangle());
    }

    @Override
    public Rectangle getRectangle()
    {
        return new Rectangle(this.x + (width - crashBoxWidth)/2,
                this.y + (height - crashBoxHeight)/2, crashBoxWidth,
                crashBoxHeight);
    }

    public float getDefence()
    {
        return defence;
    }

    public void setDefence(float defence)
    {
        this.defence = defence;
    }

    public float getHp()
    {
        return hp;
    }

    public void setHp(float hp)
    {
        this.hp = hp;
    }

    public void setDeath(boolean death)
    {
        this.death = death;
    }

    public boolean isDeath()
    {
        return this.death;
    }

    @Override
    public float getYSPeed()
    {
        return this.ySpeed;
    }

    @Override
    public void setYSPeed(float f)
    {
        this.ySpeed = f;
    }

    @Override
    public void drawImage(Graphics g)
    {
        super.drawImage(g);
//        Rectangle rectangle = getRectangle();
//        g.drawImage(CommonUtils.getImage("test.png"),rectangle.x,rectangle.y,rectangle.width,rectangle.height,null);
    }
}
