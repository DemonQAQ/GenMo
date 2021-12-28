package demon.sprite;

import demon.base.function.Direction;
import demon.base.function.Element;
import demon.base.function.CreatureState;
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
@Element(width = 200, height = 148, crashWidth = 150,crashHeight = 148,yAcceleration = 40.0f,
        Image =
        "playerIdle.gif")
public class Player extends Creature
{
    private Image idle = Image;
    private Image run = CommonUtils.getImage("playerRun.gif");
    private Image fall = CommonUtils.getImage("playerFall.gif");
    private Image attack = CommonUtils.getImage("playerAttack.gif");
    private AttackSkill attackSkill = new AttackSkill(this,5);

    Player()
    {
        this.state = new CreatureState();
    }

    public Player(int x, int y)
    {
        super(x, y);
        this.state = new CreatureState();
    }

    @Override
    public void action()
    {
        checkState();
        executeSkill();
        super.action();
    }

    private void executeSkill()
    {
        if (Keys.ATTACK.use()&&!state.isAttack())attackSkill.action();
    }

    @Override
    protected void checkState()
    {
        if (state.isAttack())
        {
            if (this.direction == Direction.RIGHT) this.Image = attack;
            else this.Image = FlipImage.flipImage(attack);
            return;
        }
        if (state.isFly())
        {
            if (this.direction == Direction.RIGHT) this.Image = fall;
            else this.Image = FlipImage.flipImage(fall);
            return;
        }
        if (state.isRun() && !state.isFly())
        {
            if (this.direction == Direction.RIGHT) this.Image = run;
            else this.Image = FlipImage.flipImage(run);
            return;
        }
        if (state.isIdle())
        {
            if (this.direction == Direction.RIGHT) this.Image = idle;
            else this.Image = FlipImage.flipImage(idle);
        }
    }

    @Override
    public void xMove()
    {
        if (!Keys.LEFT.use() && !Keys.RIGHT.use())
        {
            this.state.setRun(false);
            this.state.setIdle(true);
            this.xSpeed = xAcceleration;//,重置玩家速度
            return;
        }
        //水平移动
        if (Keys.LEFT.use())
        {
            if (this.x > 0)
            {
                this.state.setRun(true);
                this.xSpeed = xSpeedMax < (this.xSpeed + xAcceleration) ? xSpeedMax : xSpeed + xAcceleration;
                this.x -= this.xSpeed;
            }
            this.direction = Direction.LEFT;//更改玩家方向
        } else if (Keys.RIGHT.use())
        {
            if (this.x <= Constant.FRAME_WIDTH)
            {
                this.state.setRun(true);
                this.xSpeed = xSpeedMax < (this.xSpeed + xAcceleration) ? xSpeedMax : xSpeed + xAcceleration;
                this.x += this.xSpeed;
            }
            this.direction = Direction.RIGHT;//更改玩家方向
        }
    }

    @Override
    public void yMove()
    {
        if (Keys.JUMP.use() && !state.isFly())
        {
            if (onTheGround())
            {
                this.ySpeed = this.yAcceleration;
                setGroundFLag(false);
            } else if (this.ySpeed > 0)
            {
                this.ySpeed -= 1;
            }
            this.y -= ySpeed;
        } else
        {
            ySpeed = 0;
            if (!onTheGround())state.setFly(true);
        }
    }
}
