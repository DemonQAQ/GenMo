package demon.base.function;

/*
 * GenMo demon.base.function
 * @Author:Demon
 * @Date:2021/12/27 16:58
 * @Description:
 */
public class PlayerState
{
    private boolean fly = false;
    private boolean attack = false;
    private boolean run = false;
    private boolean idle = true;

    public boolean isRun()
    {
        return run;
    }

    public void setRun(boolean run)
    {
        this.run = run;
    }

    public boolean isIdle()
    {
        return idle;
    }

    public void setIdle(boolean idle)
    {
        this.idle = idle;
    }

    public PlayerState(){}

    public boolean isFly()
    {
        return fly;
    }

    public void setFly(boolean fly)
    {
        this.fly = fly;
    }

    public boolean isAttack()
    {
        return attack;
    }

    public void setAttack(boolean attack)
    {
        this.attack = attack;
    }
}
