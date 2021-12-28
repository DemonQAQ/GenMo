package demon.sprite;

import demon.base.BaseService.DamageBaseService;
import demon.base.function.Direction;
import demon.util.CommonUtils;
import demon.util.GetService;
import demon.util.Keys;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/*
 * GenMo demon.sprite
 * @Author:Demon
 * @Date:2021/12/27 23:44
 * @Description:
 */
public class AttackSkill extends Skill
{
    AttackSkill(Player player, float f)
    {
        this.player = player;
        this.damageRectangleSprite = new DamageRectangleSprite();
        this.damageRectangleSprite.setDamage(f);
        this.damageRectangleSprite.setPlayer(true);
    }

    @Override
    public void action()
    {
        action(null);
    }

    public void action(Creature creature)
    {
        if (player.direction == Direction.RIGHT)
            this.damageRectangleSprite.setRectangle(new Rectangle(player.x + 50, player.y,
                    50, player.height));
        else this.damageRectangleSprite.setRectangle(new Rectangle(player.x - 50, player.y,
                50, player.height));

        player.state.setAttack(true);
        this.endFlag=false;

        DamageBaseService service = GetService.getDamage();
        service.add(this.damageRectangleSprite);
        Timer timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                service.remove(damageRectangleSprite);
                player.state.setAttack(false);
            }
        }, 700);
    }
}
