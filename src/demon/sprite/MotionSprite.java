package demon.sprite;

/*
 * GenMo demon.base
 * @Author:Demon
 * @Date:2021/12/27 8:57
 * @Description:
 */
public class MotionSprite extends Sprite
{
    float xSpeed = 1.0f, ySpeed = 0.0f;
    protected float xAcceleration = 0.5f;//水平加速度
    protected float yAcceleration = 24.0f;//垂直加速度
    protected float xSpeedMax = 8.0f;//水平速度最大值

    MotionSprite()
    {
    }
    MotionSprite(int x, int y)
    {
        super(x, y);
    }

    public boolean beforeActionJudge()
    {
        return true;
    }

    public boolean afterActionJudge()
    {
        return true;
    }

    public void action()
    {
        this.xMove();
        this.yMove();
    }

    public void xMove()
    {
        this.x += direction.right() ? xSpeed : -xSpeed;
    }

    public void yMove()
    {
        this.y -= this.ySpeed;
    }

    public float getXSpeed()
    {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed)
    {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed()
    {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed)
    {
        this.ySpeed = ySpeed;
    }

}
