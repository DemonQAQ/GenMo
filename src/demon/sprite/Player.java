package demon.sprite;

import demon.base.function.Audio;
import demon.base.function.Direction;
import demon.base.function.Element;
import demon.base.function.CreatureState;
import demon.util.*;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/*
 * GenMo demon.base
 * @Author:Demon
 * @Date:2021/12/27 9:01
 * @Description:
 */
@Element(width = 200, height = 148, crashWidth = 70,crashHeight = 148,yAcceleration = 28.0f,
        Image =
        "playerIdle.gif",direction = Direction.RIGHT,hp = 5000)
public class Player extends Creature
{
    private Image idle = Image;
    private Image run = CommonUtils.getImage("playerRun.gif");
    private Image fall = CommonUtils.getImage("playerFall.gif");
    private Image attack = CommonUtils.getImage("playerAttack1.gif");
    private Image attack2 = CommonUtils.getImage("playerAttack2.gif");
    private Image attack3 = CommonUtils.getImage("playerAttack3.gif");
    private Image die = CommonUtils.getImage("playerDie.gif");
    private Image hurt = CommonUtils.getImage("playerHurt.gif");
    private Image jump = CommonUtils.getImage("playerJump.gif");
    private Image cast = CommonUtils.getImage("playerCast.gif");
    private int tick =0;
    private PlayerAttackSkill playerAttackSkill = new PlayerAttackSkill(this,50,200);
    private PlayerThunderBird playerThunderBird = new PlayerThunderBird(this,100,25,"thunderBird");


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
        if (Keys.ATTACK.use()&&!state.isAttack()) playerAttackSkill.action();
        if (Keys.SKILL1.use()&&!state.isSkillThunderBird())playerThunderBird.action();
    }

    @Override
    protected void checkState()
    {
        if (this.isDeath())
        {
            if (this.direction == Direction.RIGHT) this.Image = die;
            else this.Image = FlipImage.flipImage(die);
            Player p = this;
            if (tick == 0)
            {
                Audio.PLAYER_DEATH.play();
                tick++;
            }
            new Timer().schedule(new TimerTask()
            {
                @Override
                public void run()
                {
                    GetService.getCreature().remove(p);
                    cancel();
                }
            }, 700);
            return;
        }
        if (this.state.isSkillThunderBird())
        {
            if (tick == 0)
            {
                Audio.PLAYER_MAGIC1.play();
                if (this.direction == Direction.RIGHT) this.Image = cast;
                else this.Image = FlipImage.flipImage(cast);
                tick++;
                new Timer().schedule(new TimerTask()
                {
                    @Override
                    public void run()
                    {
                        tick=0;
                        cancel();
                    }
                }, 500);
            }
        }
        if (state.isAttack())
        {
            if (this.state.isAttack1())
            {
                this.Image=attack;
            }
            else if(this.state.isAttack2())
            {
                this.Image=attack2;
            }
            else
            {
                this.Image=attack3;
            }
            if (this.direction == Direction.RIGHT);
            else this.Image = FlipImage.flipImage(this.Image);
            return;
        }
        if (state.isHurt())
        {
            if (this.direction == Direction.RIGHT) this.Image = hurt;
            else this.Image = FlipImage.flipImage(hurt);
            return;
        }
        if (state.isJump())
        {
            if (this.direction == Direction.RIGHT) this.Image = jump;
            else this.Image = FlipImage.flipImage(jump);
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
            tick++;
            if (tick>50)
            {
                state.setAttack1(false);
                state.setAttack2(false);
                state.setAttack3(false);
                tick = 0;
            }
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
        if (Keys.LEFT.use()&&!state.isAttack())
        {
            if (this.x > Constant.LEFT_EDGE)
            {
                this.state.setRun(true);
                this.xSpeed = xSpeedMax < (this.xSpeed + xAcceleration) ? xSpeedMax : xSpeed + xAcceleration;
                this.x -= this.xSpeed;
            }
            this.direction = Direction.LEFT;//更改玩家方向
            return;
        } else if (Keys.RIGHT.use()&&!state.isAttack())
        {
            if (this.x <= Constant.RIGHT_EDGE)
            {
                this.state.setRun(true);
                this.xSpeed = xSpeedMax < (this.xSpeed + xAcceleration) ? xSpeedMax : xSpeed + xAcceleration;
                this.x += this.xSpeed;
            }
            this.direction = Direction.RIGHT;//更改玩家方向
            return;
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
                this.state.setJump(true);
            } else if (this.ySpeed > 0)
            {
                this.ySpeed -= 1;
                if (ySpeed<=0)
                {
                    state.setFly(true);
                    state.setJump(false);
                }
            }
            this.y -= ySpeed;
        } else
        {
            ySpeed = 0;
            if (!onTheGround())state.setFly(true);
            state.setJump(false);
        }
    }
}
