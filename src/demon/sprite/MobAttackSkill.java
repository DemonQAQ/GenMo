package demon.sprite;

import demon.base.BaseService.DamageBaseService;
import demon.base.function.Audio;
import demon.base.function.Direction;
import demon.util.GetService;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/*
 * GenMo demon.sprite
 * @Author:Demon
 * @Date:2021/12/29 8:57
 * @Description:
 */
public class MobAttackSkill extends Skill
{
    MobAttackSkill(Mob mob,float damage,long tick)
    {
        this.mob = mob;
        this.damageRectangleSprite = new DamageRectangleSprite();
        this.damageRectangleSprite.setDamage(damage);
        this.damageRectangleSprite.setPlayer(false);
        this.damageRectangleSprite.setTick(tick);
    }
    @Override
    public void action()
    {
        action(null);
    }

    public void action(Creature creature)
    {
        if (mob.direction == Direction.RIGHT)
            this.damageRectangleSprite.setRectangle(new Rectangle(mob.x + mob.crashBoxWidth/2,
                    mob.y,
                    100, mob.height));
        else this.damageRectangleSprite.setRectangle(new Rectangle(mob.x - mob.crashBoxWidth/2,
                mob.y,
                100, mob.height));

        mob.state.setAttack(true);
        DamageBaseService service = GetService.getDamage();
        service.add(this.damageRectangleSprite);
        new Timer().schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                Audio.GOLEM_ATTACK.play();
                cancel();
            }
        }, 1000);
        new Timer().schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                Audio.GOLEM_ATTACK.play();
                mob.state.setAttack(false);
                cancel();
            }
        }, 1500);
    }
}
