package demon.base.function;

/*
 * GenMo demon.base.function
 * @Author:Demon
 * @Date:2021/12/27 16:58
 * @Description:
 */
public class CreatureState
{
    private boolean fly = false;
    private boolean jump = false;
    private boolean attack = false;
    private boolean attack1 = false;
    private boolean attack2 = false;
    private boolean attack3 = false;
    private boolean run = false;
    private boolean idle = true;
    private boolean hurt = false;
    private boolean unbeatable = false;
    private boolean skillThunderBird = false;

    public boolean isSkillThunderBird()
    {
        return skillThunderBird;
    }

    public void setSkillThunderBird(boolean skillThunderBird)
    {
        this.skillThunderBird = skillThunderBird;
    }

    public boolean isUnbeatable()
    {
        return unbeatable;
    }

    public void setUnbeatable(boolean unbeatable)
    {
        this.unbeatable = unbeatable;
    }

    public boolean isHurt()
    {
        return hurt;
    }

    public void setHurt(boolean hurt)
    {
        this.hurt = hurt;
    }

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

    public CreatureState()
    {
    }

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

    public boolean isJump()
    {
        return jump;
    }

    public void setJump(boolean jump)
    {
        this.jump = jump;
    }


    public boolean isAttack1()
    {
        return attack1;
    }

    public void setAttack1(boolean attack1)
    {
        this.attack1 = attack1;
    }

    public boolean isAttack2()
    {
        return attack2;
    }

    public void setAttack2(boolean attack2)
    {
        this.attack2 = attack2;
    }

    public boolean isAttack3()
    {
        return attack3;
    }

    public void setAttack3(boolean attack3)
    {
        this.attack3 = attack3;
    }
}
