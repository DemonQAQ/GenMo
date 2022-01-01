package demon.sprite;

import demon.base.BaseService.DamageBaseService;
import demon.base.function.Audio;
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
public class PlayerAttackSkill extends Skill
{
    PlayerAttackSkill(Player player, float f,long tick)
    {
        this.player = player;
        this.damageRectangleSprite = new DamageRectangleSprite();
        this.damageRectangleSprite.setDamage(f);
        this.damageRectangleSprite.setPlayer(true);
        this.damageRectangleSprite.setTick(tick);
    }

    @Override
    public void action()
    {
        action(null);
    }

    public void action(Creature creature)
    {
        if (player.direction == Direction.RIGHT)
            this.damageRectangleSprite.setRectangle(new Rectangle(player.x + player.crashBoxWidth, player.y,
                    150, player.height));
        else this.damageRectangleSprite.setRectangle(new Rectangle(player.x - player.crashBoxWidth, player.y,
                150, player.height));

        player.state.setAttack(true);
        if (player.state.isAttack3())
        {
            player.state.setAttack1(true);
            player.state.setAttack3(false);
            Audio.PLAYER_ATTACK1.play();
        }
        else if (player.state.isAttack2())
        {
            player.state.setAttack2(false);
            player.state.setAttack3(true);
            Audio.PLAYER_ATTACK2.play();
        }
        else if (player.state.isAttack1())
        {
            player.state.setAttack1(false);
            player.state.setAttack2(true);
            Audio.PLAYER_ATTACK3.play();
        }
        else
        {
            player.state.setAttack1(true);
            Audio.PLAYER_ATTACK1.play();
        }
        DamageBaseService service = GetService.getDamage();
        service.add(this.damageRectangleSprite);
        new Timer().schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                player.state.setAttack(false);
                cancel();
            }
        }, 700);
    }
}
