package demon.sprite;

import demon.base.function.Direction;
import demon.base.function.Element;
import demon.base.function.PlayerState;
import demon.util.CommonUtils;
import demon.util.Constant;
import demon.util.FlipImage;
import demon.util.Keys;

import java.awt.*;

/*
 * GenMo demon.base
 * @Author:Demon
 * @Date:2021/12/27 9:01
 * @Description:
 */
@Element(width = 100,height = 74,leftImage = "playerIdle.gif")
public class Player extends GravityMotionSprite
{
    private Image Idle = Image;
    private Image run = CommonUtils.getImage("playerRun.gif");
    private Image Fall = CommonUtils.getImage("playerFall.gif");
    public PlayerState state = new PlayerState();
    Player()
    {
    }

    public Player(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void action()
    {
        checkState();
        super.action();
    }

    private void checkState()
    {
        if (state.isFly())
        {
            if (this.direction == Direction.RIGHT)this.Image=Fall;
            else this.Image = FlipImage.flipImage(Fall);
        }
        else
        {
            if(state.isRun())
            {
                if (this.direction == Direction.RIGHT)this.Image = run;
                else this.Image = FlipImage.flipImage(run);
            }
            else
            {
                if (this.direction == Direction.RIGHT)this.Image = Idle;
                else this.Image=FlipImage.flipImage(Idle);
            }
        }
    }

    @Override
    public void xMove()
    {
        if (!Keys.LEFT.use() && !Keys.RIGHT.use())
        {
            this.state.setRun(false);
            this.state.setIdle(true);
            this.ySpeed = this.yAcceleration;//,重置玩家速度
            return;
        }
        //水平移动
        if (Keys.LEFT.use())
        {
            if (this.x > 0)
            {
                this.state.setRun(true);
                this.x -= this.xSpeed;
            }
            this.direction = Direction.LEFT;//更改玩家方向
        } else if(Keys.RIGHT.use())
        {
            if (this.x <= Constant.FRAME_WIDTH/2)
            {
                this.state.setRun(true);
                this.x += this.xSpeed;
            }
            this.direction = Direction.RIGHT;//更改玩家方向
        }
    }

    @Override
    public void yMove()
    {
        if (Keys.JUMP.use()&&!state.isFly())
        {
            if (onTheGround())
            {
                this.ySpeed = this.yAcceleration;
                setGroundFLag(false);
            }
            else if (this.ySpeed>0)
            {
                this.ySpeed-=1;
            }
            this.y-=ySpeed;
        }
        else
        {
            ySpeed = 0;
            state.setFly(true);
        }
    }
}
