package demon.sprite;

import demon.base.function.Audio;
import demon.base.function.CreatureState;
import demon.base.function.Direction;
import demon.base.function.Element;
import demon.util.*;

import java.awt.*;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

/*
 * GenMo demon.sprite
 * @Author:Demon
 * @Date:2021/12/28 15:02
 * @Description:
 */
@Element(width = 580, height = 280, crashWidth = 150, crashHeight = 220, Image =
        "golemIdle.gif", direction = Direction.LEFT, hp = 5000)
public class Golem extends Mob
{
    private Image idle;
    private Image hurt = CommonUtils.getImage("golemBehurt.gif");
    private Image attack = CommonUtils.getImage("golemAttack.gif");
    private Image die = CommonUtils.getImage("golemDie.gif");
    private Image run = CommonUtils.getImage("golemRun.gif");
    private MobAttackSkill mobAttackSkill = new MobAttackSkill(this, 200, 1000);

    private int tick = 0;

    Golem()
    {
        state = new CreatureState();
        this.idle = this.getImage();
    }

    public Golem(int x, int y)
    {
        super(x, y);
        this.idle = this.getImage();
        this.state = new CreatureState();
    }

    @Override
    void checkState()
    {
        if (this.isDeath())
        {
            if (this.direction == Direction.RIGHT) this.Image = die;
            else this.Image = FlipImage.flipImage(die);
            Golem g = this;
            if (tick == 0)
            {
                Audio.GOLEM_DEATH.play();
                tick++;
            }
            new Timer().schedule(new TimerTask()
            {
                @Override
                public void run()
                {
                    GetService.getCreature().remove(g);
                    tick = 0;
                    cancel();
                }
            }, 2500);
            return;
        }
        if (state.isHurt())
        {
            if (this.direction == Direction.RIGHT) this.Image = hurt;
            else this.Image = FlipImage.flipImage(hurt);
            return;
        }
        if (state.isAttack())
        {
            if (this.direction == Direction.RIGHT) this.Image = attack;
            else this.Image = FlipImage.flipImage(attack);
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
    public void autoXMove()
    {
        if (this.direction == Direction.RIGHT)
        {
            if (this.x < Constant.RIGHT_EDGE) this.x += xSpeed;
            else this.direction = Direction.LEFT;
        } else
        {
            if (this.x > Constant.LEFT_EDGE) this.x -= xSpeed;
            else this.direction = Direction.RIGHT;
        }
    }

    @Override
    public void xMove()
    {
    }

    @Override
    public void yMove()
    {
        autoYMove();
    }

    private void actionJudge()
    {
        if (!onTheGround()) return;
        int x = GetService.getPlayer().getPlayerLocation();
        if (Math.abs(x - this.x) < 300)
        {
            if (CommonUtils.nextInt(0, 100) > 5) return;
            if (this.x < x) this.direction = Direction.RIGHT;
            else this.direction = Direction.LEFT;
            if (!this.state.isAttack()) attackEvent();
        } else if (!this.state.isAttack())
        {
            if (CommonUtils.nextInt(0, 100) > 10) return;
            if (this.x < x) this.direction = Direction.RIGHT;
            else this.direction = Direction.LEFT;
            moveEvent();
        }

    }

    private void moveEvent()
    {
        this.state.setRun(true);
        this.setXSpeed(1);
        Golem g = this;
        new Timer().schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                g.setXSpeed(0);
                g.state.setRun(false);
                cancel();
            }
        }, 3000);
    }

    private void attackEvent()
    {
        mobAttackSkill.action();
    }

    @Override
    public void action()
    {
        checkState();
        if (!this.isDeath())
        {
            actionJudge();
            autoXMove();
        }
    }
}
