package demon.base;

import demon.base.BaseService.CreatureBaseService;
import demon.base.BaseService.DamageBaseService;
import demon.base.BaseService.EffectBaseService;
import demon.base.function.Audio;
import demon.sprite.Golem;
import demon.sprite.Ground;
import demon.sprite.Player;
import demon.util.CommonUtils;
import demon.util.GDraw;
import demon.util.GetService;

import java.awt.*;

/*
 * GenMo demon.base
 * @Author:Demon
 * @Date:2021/12/27 11:07
 * @Description:
 */
public class GameContent implements GDraw
{
    private Golem test = new Golem(500,0);
    Player player = new Player(0,0);

    public GameContent(Ground ground)
    {
        GetService.getGravity().add(player);
        GetService.getGravity().add(test);
        GetService.getGround().setGround(ground);
        GetService.getGround().add(player);
        GetService.getGround().add(test);
        GetService.getCreature().add(test);
        GetService.getCreature().add(player);
        GetService.getPlayer().add(player);
        player.setGroundFLag(false);
        CommonUtils.task(25, () -> {
            player.action();//玩家动作
            this.wholeAction(player);//游戏整体动作
            GetService.getGravity().universalGravitation();//万有引力
        });
        CommonUtils.task(1, () -> GetService.getGround().groundJudge(ground));
        CommonUtils.task(81 * 1000, Audio.BACKGROUND::play);
    }

    private void wholeAction(Player player)
    {
        CreatureBaseService creature = GetService.getCreature();
        creature.action(player);
        DamageBaseService damage = GetService.getDamage();
        damage.action(creature);
        EffectBaseService effect = GetService.getEffect();
        effect.action();

    }
    @Override
    public void drawImage(Graphics g)
    {
        GetService.getGround().drawImage(g);
        GetService.getCreature().drawImage(g);
        GetService.getEffect().drawImage(g);
        GetService.getDamage().drawImage(g);
    }
}
