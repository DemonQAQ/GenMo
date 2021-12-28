package demon.sprite;

import demon.base.function.CreatureState;
import demon.base.function.Direction;
import demon.base.function.Element;

import java.awt.*;

/*
 * GenMo demon.base
 * @Author:Demon
 * @Date:2021/12/27 9:01
 * @Description:
 */
public class Creature extends GravityMotionSprite
{
    protected float hp;
    protected float defence;
    protected boolean death = false;
    public CreatureState state;
    public int crashBoxWidth,crashBoxHeight;

    Creature(){}
    Creature(int x,int y)
    {
        super(x, y);
        Element ann = this.getClass().getAnnotation(Element.class);
        this.crashBoxWidth = ann.crashWidth();
        this.crashBoxHeight = ann.crashWidth();
    }
    public void crash(Creature obj)
    {
        if (Math.abs(this.getX()-obj.getX())>Math.abs(this.getX()-(obj.getX()+ (obj.direction == Direction.RIGHT?
                obj.getXSpeed():-obj.getXSpeed()))))
        {
            if (obj.state.isFly())
            {
                obj.setYSpeed(10);
                obj.setXSpeed(-5);
            }
            else if (obj.state.isRun())
            {
                obj.state.setRun(false);
                obj.state.setIdle(true);
                obj.setXSpeed(-5);
            }
        }
    }

    void checkState(){}

    @Override
    public Rectangle getRectangle()
    {
        return new Rectangle(this.x,this.y,crashBoxWidth,crashBoxHeight);
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
}
