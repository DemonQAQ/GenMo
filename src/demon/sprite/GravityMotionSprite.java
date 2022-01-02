package demon.sprite;

import demon.base.function.Element;
import demon.base.function.Gravity;

/*
 * GenMo demon.base
 * @Author:Demon
 * @Date:2021/12/27 9:00
 * @Description:
 */
public class GravityMotionSprite extends MotionSprite implements Gravity
{
    protected float quality = 50;
    protected boolean onTheGround = false;

    GravityMotionSprite()
    {
        Element ann = this.getClass().getAnnotation(Element.class);
        setXSpeed(0);
        this.xAcceleration = ann.xAcceleration();
        this.yAcceleration = ann.yAcceleration();
    }

    GravityMotionSprite(int x, int y)
    {
        super(x, y);
        Element ann = this.getClass().getAnnotation(Element.class);
        setXSpeed(0);
        this.xAcceleration = ann.xAcceleration();
        this.yAcceleration = ann.yAcceleration();
    }

    public void setGroundFLag(boolean onTheGround)
    {
        this.onTheGround = onTheGround;
    }

    @Override
    public boolean onTheGround()
    {
        return onTheGround;
    }

    @Override
    public float getQuality()
    {
        return this.quality;
    }

    @Override
    public float getYSPeed()
    {
        return 0;
    }

    @Override
    public int getY()
    {
        return this.y;
    }

    @Override
    public void setY(int y)
    {
        this.y = y;
    }

    public void setQuality(float quality)
    {
        this.quality = quality;
    }
}
